package is.hi.alicia.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.googlejavaformat.java.FormatterException;

import is.hi.alicia.beautifier.JavaBeautifier;
import is.hi.alicia.diff.GoogleDiff;
import is.hi.alicia.model.Answer;
import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;
import is.hi.alicia.model.Employee;
import is.hi.alicia.model.Employer;
import is.hi.alicia.model.User;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private final CourseRepository courseRep;
	private final UserRepository userRep;

	@Autowired
	public DatabaseLoader(CourseRepository courseRep, UserRepository userRep) {
		this.courseRep = courseRep;
		this.userRep = userRep;
	}

	@Override
	public void run(String... strings) throws Exception {

		// User user = new User();
		// user.setName("Hallgrímur Davíð");
		// userRep.save(user);
		//
		// User user2 = new User();
		// user2.setName("Steina Dögg");
		// userRep.save(user2);
		//
		// Course course = new Course();
		// course.setName("Tölvunarfræði 1 (hefur eitt verkefni)");
		//
		// Course course2 = new Course();
		// course2.setName("Tölvunarfræði 2 (engin verkefni)");
		// courseRep.save(course2);
		//
		// Assignment assignment = new Assignment();
		// assignment.setTitle("Verkefni 1");
		// assignment.setReturnDate(new Date());
		// assignment.setQuestionDescription("# Verkefni 5\n" +
		// "\n" +
		// "Skrifið Java forritið VixlaPorum.java sem fær á skipanalínunni N bókstafi og
		// skrifar þá út þannig að hliðstæðum\n" +
		// "stökum hefur verið víxlað. \n" +
		// "\n" +
		// "Til dæmis ef stafirnir á skipanalínunni eru A B C D E, þá skrifar forritið
		// út B A D C\n" +
		// "E. \n" +
		// "\n" +
		// "Það víxlar fyrstu tveimur stöfunum og næstu tveimur, en þar sem fjöldinn er
		// oddatala þá er síðasti stafurinn\n" +
		// "óbreyttur.\n" +
		// "\n" +
		// "");
		//
		// JavaBeautifier jb = new JavaBeautifier();
		// File teachersolution = new
		// File("src/main/resources/demosolutions/Lausn.java");
		// String teachersol = "";
		// try {
		// teachersol = FileUtils.readFileToString(teachersolution);
		// assignment.setTeacherSolution(jb.beautify(teachersol));
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// GoogleDiff gd = new GoogleDiff();
		//
		// File f = new File("src/main/resources/demosolutions");
		// String [] extension = new String[] {"java"};
		// Iterator<File> it = FileUtils.iterateFiles(f, extension, false);
		// List<Answer> answerList= new ArrayList<Answer>();
		//
		// while (it.hasNext()) {
		// try {
		// String answer = jb.beautify(FileUtils.readFileToString(it.next()));
		// Answer ans = new Answer();
		// ans.setSourceCode(answer);
		// ans.setDistance(gd.calculateDistance(teachersol, answer));
		// answerRep.save(ans);
		// ans.setAssignment(assignment);
		// answerList.add(ans);
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// assignment.setAnswers(answerList);
		// System.out.println("Number of assignments::::: " +
		// assignment.getAnswers().size() );
		// assignmentRepository.save(assignment);
		// course.addAssignment(assignment);
		// courseRep.save(course);

		test();

	}

	private void test() throws FormatterException, IOException {
		JavaBeautifier jb = new JavaBeautifier();

		User user = new User();
		user.setEmail("steina@wham.com");
		user.setName("Steina Dögg");

		Assignment assignment = new Assignment();
		assignment.setTeacherSolution(
				jb.beautify(FileUtils.readFileToString(new File("src/main/resources/demosolutions/Lausn.java"))));

		assignment.setQuestionDescription("Question description");

		assignment.setTitle("Verkefni 1");

		Course course = new Course();
		course.getAssignments().add(assignment);
		course.setName("Tölvunarfræði 1");
		course.setIdentifier("TÖL101");
		assignment.setCourse(course);

		user.getCourses().add(course);
		course.getUsers().add(user);

		// Need to save seperately due to many-many relationship.
		userRep.save(user);
		courseRep.save(course);
		
		manyCourses();

	}

	private void manyCourses() {
		for (int x = 0; x < 10; x++) {
			Course crs = new Course();
			crs.setIdentifier("TÖL20" + x );
			crs.setName("Tölvunafræði " + x);
			courseRep.save(crs);
		}

	}

}