package is.hi.alicia.diff;

import java.io.IOException;

/**
 * 
 * @author Steina Dogg Vigfusdottir sdv6@hi.is
 * Feb 12, 2018
 * University of Iceland
 * 
 * Implementations of this interface are used to generate a "difference" between
 * two source codes.
 * 
 * Conform to it to implement different algorithms for Alicia.
 */
interface CompareSourceCode {
	
	public int calculateDistance(String a, String b) throws IOException;
}
