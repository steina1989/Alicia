package is.hi.alicia.beautifier;

import java.io.File;
import java.util.List;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

public class JavaBeautifier implements Beautifier {

	@Override
	public String beautify(String sourcecode) throws FormatterException {
		return new Formatter().formatSource(sourcecode);
	}



}
