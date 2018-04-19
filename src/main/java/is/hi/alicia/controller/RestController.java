package is.hi.alicia.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.googlejavaformat.FormatterDiagnostic;
import com.google.googlejavaformat.java.FormatterException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import is.hi.alicia.beautifier.JavaBeautifier;
import is.hi.alicia.diff.GoogleDiff;
import is.hi.alicia.model.Answer;
import is.hi.alicia.model.Assignment;
import is.hi.alicia.repository.AssignmentRepository;


@RepositoryRestController
@RequestMapping(value="/api")
@MultipartConfig(fileSizeThreshold = 20971520)
public class RestController extends ResourceSupport{

	private final AssignmentRepository assignmentRep;
	private final GoogleDiff googleDiff;
	private final JavaBeautifier beautifier;


	@Autowired
	RestController(AssignmentRepository ar){
		this.assignmentRep = ar;
		this.googleDiff = new GoogleDiff();
		this.beautifier = new JavaBeautifier();
	}


	@RequestMapping(value="/addAnswer/{assignmentId}", method = RequestMethod.POST)
	ResponseEntity<?> addAnswer(@PathVariable Long assignmentId, @RequestParam("uploadedFile") MultipartFile uploadedFileRef) {

		Answer answer = new Answer();
		try {
			String res = parseMultiPartFormData(uploadedFileRef);
			answer.setSourceCode(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
		
		boolean beautifySuccess = beautify(answer);

		Assignment assignment = assignmentRep.findOne(assignmentId);
		String teacherSolution = assignment.getTeacherSolution();
		String compareSolution = (beautifySuccess)? answer.getSourceCodeBeautified() : answer.getSourceCode();

		answer.setDistance(calculateDistance(teacherSolution,compareSolution ));

		assignment.getAnswers().add(answer);
		assignment = assignmentRep.save(assignment);	

		URI location = ServletUriComponentsBuilder
				.fromPath("/api/answers/").path("/{id}")
				.buildAndExpand(assignment.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	/*
	 * Returns a boolean indicating whether beautifier was successful or not.
	 * If unsuccessful, it builds a new line seperated string of its diagnostics.
	 */
	private boolean beautify(Answer answer) {
		try {
			String beatified = beautifier.beautify(answer.getSourceCode());
			answer.setSourceCodeBeautified(beatified);
			return true;
		} catch (FormatterException e) {
			StringBuilder sb = new StringBuilder();
			for (FormatterDiagnostic fd : e.diagnostics()) {
				sb.append(fd.toString() + "\n" );
			}	
			answer.setFormatterDiagnostics(sb.toString());
			return false;
		}		
	}
	
	private int calculateDistance(String a, String b) {
		return googleDiff.calculateDistance(a,b);
	}
	
	private String parseMultiPartFormData(MultipartFile multiPartFile) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(multiPartFile.getBytes());
		return IOUtils.toString(stream, "UTF-8");
		
	}


}
