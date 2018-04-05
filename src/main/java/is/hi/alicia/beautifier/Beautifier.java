package is.hi.alicia.beautifier;

import com.google.googlejavaformat.java.FormatterException;

/**
 * 
 * @author Steina Dogg Vigfusdottir sdv6@hi.is
 * Feb 11, 2018
 * University of Iceland
 * 
 * Conform to this interface when adding additional beautifiers to the project.
 *
 */
interface Beautifier {
	
	public String beautify(String sourcecode) throws FormatterException ;
	
}
