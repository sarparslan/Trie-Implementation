//-----------------------------------------------------
// Title: LSD class
// Author: Sarp ARSLAN - 11458145526 - Section03
// Burak SAĞLAM – 13760307838 - Section02
// Description: LSD class for performing LSD string sort
//-----------------------------------------------------
public class LSD {

    /**
     * Sorts a string using LSD (Least Significant Digit) string sort algorithm.
     *
     * @param str The string to be sorted.
     * @return The sorted string.
     */
    public static String sort(String str) {
        int R = 256; // Radix (number of possible characters)
        int N = str.length();
        char[] a = str.toCharArray();
        char[] aux = new char[N];

        for (int d = N - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // Count the frequency of each character
            for (int i = 0; i < N; i++) {
                count[a[i] + 1]++;
            }

            // Calculate cumulative counts
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // Distribute the characters to the auxiliary array
            for (int i = 0; i < N; i++) {
                aux[count[a[i]]++] = a[i];
            }

            // Copy the characters back to the original array
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }

        String sortedStr = new String(a);
        return sortedStr;
    }

}
