package strings;

//    https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class kmpsubstringsearch {
	public static void KMPSearch(String pat, String txt) {
		int lengthOfPattern = pat.length();
		int lengthOfText = txt.length();
		int lps[] = new int[lengthOfPattern];
		int indexofpatt = 0; // index for pat[]
		
		computeLPSArray(pat, lengthOfPattern, lps);

		int indexOfText = 0; // index for txt[]
		while (indexOfText < lengthOfText) {
			if (pat.charAt(indexofpatt) == txt.charAt(indexOfText)) {
				indexofpatt++;
				indexOfText++;
			}
			if (indexofpatt == lengthOfPattern) {
				System.out.println("Found pattern " + "at index " + (indexOfText - indexofpatt));
				indexofpatt = lps[indexofpatt - 1];
			} else if (indexOfText < lengthOfText && pat.charAt(indexofpatt) != txt.charAt(indexOfText)) {
				if (indexofpatt != 0)
					indexofpatt = lps[indexofpatt - 1];
				else
					indexOfText = indexOfText + 1;
			}
		}
	}

	public static void computeLPSArray(String pat, int lenOfPattern, int lps[]) {
		int j = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0
		while (i < lenOfPattern) {
			if (pat.charAt(i) == pat.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else // (pat[i] != pat[len])
			{
				if (j != 0) {
					j = lps[j - 1];
				} else // if (len == 0)
				{
					lps[i] = j;
					i++;
				}
			}
		}
	}

	public static void main(String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		KMPSearch(pat, txt);
	}
}
