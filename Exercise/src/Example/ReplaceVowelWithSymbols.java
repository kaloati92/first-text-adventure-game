package Example;

public class ReplaceVowelWithSymbols {
    public static void main(String[] args) {

        replaceVowelsWithSymbol("Hello There", '+');

    }

    public static String replaceVowelsWithSymbol(String str, char symbol) {
        // TODO: Implement the method that replaces all vowels in the input String with the given symbol. English alphabet only!
        // Example: replaceVowelsWithSymbol("Hello", '#') -> "H#ll#"

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ("aeuioAEUIO".contains(String.valueOf(str.charAt(i)))) {
                result.append(symbol);
            } else {
                result.append(str.charAt(i));
            }
        }
        System.out.println(result);
        return null;
    }
}
