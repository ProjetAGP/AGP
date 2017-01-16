package tools.parse;

public class StringParser {

	public static int getIndexOfWord(String w, String chain) {
		/**
		 * get the index of the first character of the word w if chain contains
		 * the word w or -1 if chain does'nt contains w.
		 */
		int i = w.length();
		while (i < chain.length()) {
			if (chain.substring(i - w.length(), i) == w)
				return i;
			i++;
		}
		return -1;
	}

}
