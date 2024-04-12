package Example;

public class CountOccurrences {
    public static void main(String[] args) {
        int counter = countOccurrences("Hello WorLd", "l");
        System.out.println(counter);

    }

    public static int countOccurrences(String str, String target) {
        // TODO: Implement the method that counts how many times the given target appears in the input String.
        // Example: countOccurrences("Hello World", "l") -> 3
        //TODO OPTIONAL: Make it ignorecase!
        //Example: countOccurrences("Hello WorLd", "l") -> 3
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (target.toLowerCase().contains(str.toLowerCase().substring(i, i + target.length()))) {
                counter++;
            }
        }
        return counter;
    }
}
