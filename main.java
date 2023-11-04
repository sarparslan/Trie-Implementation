import java.util.*;
//-----------------------------------------------------
//Title: main class
//Author: Sarp ARSLAN - 11458145526 - Section03
//Burak SAĞLAM – 13760307838 - Section02
//Description: Main class for test the program
//-----------------------------------------------------
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the function you want to use:");
        System.out.println("1) Search");
        System.out.println("2) Count Prefix");
        System.out.println("3) Find Reverse\n");
        int count = scan.nextInt();



        String[] words = new String[count];

        TST tst = new TST();
        RWT rwt = new RWT();
        for (int i = 0; i < count; i++) {
            words[i] = scan.next();
            tst.put(words[i], i);
            rwt.put(words[i], i);
        }
        int function = scan.nextInt();

        switch (function) {
            case 1:
                String searchValue = scan.next();
                boolean result = tst.search(searchValue);
                System.out.println(result);
                break;

            case 2:
                tst.countPrefix();
                break;

            case 3:
                String suffix = scan.next();

                List<String> wordsWithSuffix = rwt.keysWithPrefix(suffix);
                Collections.sort(wordsWithSuffix);
                if (wordsWithSuffix.isEmpty()) {
                        System.out.println("No result");
                }
                   
                else{
                    for (String word : wordsWithSuffix) {
                    
                    System.out.print(word+" ");
                    
                }
                }    
                
               
                break;

            default:
                System.out.println("Invalid number");
                break;
        }
    }
}