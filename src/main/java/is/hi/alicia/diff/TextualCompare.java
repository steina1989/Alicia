package is.hi.alicia.diff;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.util.StringUtils;

public class TextualCompare implements CompareSourceCode {

	@Override
	public <E> int calculateDistance(E a, E b) throws IOException   {
		
		DefaultExecutor exec = new DefaultExecutor();
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
	    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

	    File filea = new File("a");
	    File fileb = new File("b");
		FileUtils.writeStringToFile(filea, (String) a, "UTF-8");
		FileUtils.writeStringToFile(fileb, (String) b, "UTF-8");
		String cmd = "diff -u a b";		
		
		
	    exec.setExitValues(new int[] {0,1});
	    exec.setStreamHandler(streamHandler);
	    
	    try {
			exec.execute(CommandLine.parse(cmd));
		} catch (ExecuteException e) {
			System.err.println(errorStream.toString());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	    filea.delete();
	    fileb.delete();
	   
	    int count = StringUtils.countOccurrencesOf(outputStream.toString(),"\n");
		return count;
	}


}
