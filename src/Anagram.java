/**
 * Created with IntelliJ IDEA.
 * User: Trevor Adams
 * Date: 17/09/2012
 * Time: 20:21
 *
 */

import java.io.*;
import java.util.*;

public class Anagram {
    public static void main(String args[]){

        String check = "turn";
        String checkSorted = sortString(check);
        StringBuffer results = new StringBuffer(check);

        try {
            File file = new File("/usr/share/dict/words");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String word = scanner.nextLine().trim();
                String sorted = sortString(word);
                if (sorted.equals(checkSorted) && !(check.equals(word))){
                    results.append(" ");
                    results.append(word);
                }
            }
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println(results.toString());
        }
    }

    private static String sortString(String unsorted){
        char[] content = unsorted.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}