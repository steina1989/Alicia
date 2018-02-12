package is.hi.alicia.diff;

/**
 * 
 * @author Steina Dogg Vigfusdottir sdv6@hi.is
 * Feb 12, 2018
 * University of Iceland
 * 
 * Implementations of this interface are used to generate a "difference" between
 * two source codes.
 * 
 * Conform to it to implement different algorithms.
 */
public interface CompareSourceCode {
	
	int calculateDistance(String a, String b);
}
