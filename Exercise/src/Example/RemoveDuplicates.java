package Example;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        removeDuplicates("Hello there");
    }

    public static String removeDuplicates(String str) {
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(str.charAt(i))) {
                result.add(str.charAt(i));
            }
        }
//        System.out.println(result.toString());
        for (Character character : result) {
            System.out.print(character);
        }
        return null;
    }
}
