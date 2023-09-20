import java.util.*;

//-----------------------------------------------------
// Title: Main class
// Author: Sarp ARSLAN - 11458145526 - Section03
// Burak SAĞLAM – 13760307838 - Section02
// Description: Main class for sorting arrays
//-----------------------------------------------------
public class main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> firstArrayList = new ArrayList<>();

        System.out.println("First Array:");
        String input = scan.nextLine();
        while (!input.isEmpty()) {
            firstArrayList.add(input);
            if (scan.hasNextLine()) {
                input = scan.nextLine();
            } else {
                break;
            }
        }

        List<String> secondArrayList = new ArrayList<>();
        System.out.println("Second Array");
        if (scan.hasNextLine()) {
            input = scan.nextLine();
        }
        while (!input.isEmpty()) {
            secondArrayList.add(input);
            if (scan.hasNextLine()) {
                input = scan.nextLine();
            } else {
                break;
            }
        }

        String firstArrayListData = firstArrayList.get(0);
        String firstArray[] = firstArrayListData.split(" ");

        String secondArrayListData = secondArrayList.get(0);
        String secondArray[] = secondArrayListData.split(" ");

        long firstArrayDistance[] = new long[firstArray.length];
        long secondArrayDistance[] = new long[firstArray.length];

        // Calculate distances for each element in the arrays
        for (int i = 0; i < firstArray.length; i++) {
            StringBuilder xBuilder = new StringBuilder();
            for (int j = 0; j < firstArray[i].length(); j++) {
                char letter = firstArray[i].charAt(j);
                int number = Character.toUpperCase(letter) - 'A' + 1;
                if (number < 10) {
                    xBuilder.append(number);
                } else {
                    xBuilder.append(number);
                }
            }
            firstArrayDistance[i] = Long.parseLong(xBuilder.toString());
        }

        for (int i = 0; i < secondArray.length; i++) {
            StringBuilder yBuilder = new StringBuilder();
            for (int j = 0; j < secondArray[i].length(); j++) {
                char letter = secondArray[i].charAt(j);
                int number = Character.toUpperCase(letter) - 'A' + 1;
                if (number < 10) {
                    yBuilder.append(number);
                } else {
                    yBuilder.append(number);
                }
            }
            secondArrayDistance[i] = Long.parseLong(yBuilder.toString());
        }

        long distanceBetween[] = new long[firstArray.length];
        String sortedArray[] = new String[firstArray.length];

        // Calculate the absolute distances between the elements of the arrays
        for (int i = 0; i < firstArrayDistance.length; i++) {
            distanceBetween[i] = (long) Math.abs(firstArrayDistance[i] - secondArrayDistance[i]);
        }

        // Sort the arrays based on the calculated distances
        for (int i = 0; i < firstArrayDistance.length; i++) {

            if (distanceBetween[i] % 2 == 0 && distanceBetween[i] != 0) {
                sortedArray[i] = sortEven(firstArray[i], secondArray[i]);
            } else if (distanceBetween[i] == 0) {
                sortedArray[i] = firstArray[i];
            } else if (distanceBetween[i] % 2 != 0) {
                sortedArray[i] = LSD.sort(firstArray[i]);
            }
        }

        System.out.println("Sorted Array:");

        for (String s : sortedArray) {
            System.out.print(s + " ");
        }

    }

    /**
     * Sorts the characters in the second string based on the order of their appearance in the first string.
     *
     * @param f The first string.
     * @param s The second string.
     * @return The sorted second string.
     */
    public static String sortEven(String f, String s) {
        List<Character> chars = new ArrayList<>();
        for (char ch : f.toCharArray()) {
            chars.add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (chars.contains(ch)) {
                int c = Collections.frequency(chars, ch);
                for (int i = 0; i < c; i++) {
                    result.append(ch);
                    chars.remove(Character.valueOf(ch));
                }
            }
        }

        for (char ch : chars) {
            result.append(ch);
        }

        return result.toString();
    }

}
