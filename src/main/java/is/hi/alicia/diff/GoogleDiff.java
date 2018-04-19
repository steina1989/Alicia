package is.hi.alicia.diff;

import java.io.IOException;
import java.util.LinkedList;

public class GoogleDiff implements CompareSourceCode {
	
	@Override
	public int calculateDistance(String a, String b)   {
		diff_match_patch dmp = new diff_match_patch();
		LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(a,b);
		dmp.diff_cleanupSemantic(diffs);
		return dmp.diff_levenshtein(diffs);
	}

}
