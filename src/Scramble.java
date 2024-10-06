import java.util.List;
import java.util.Iterator;

public class Scramble {

    // Method to scramble a single word
    public static String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        boolean[] swapped = new boolean[chars.length];

        for (int i = 0; i < chars.length - 1; i++) {
            // Check for "A" followed by a non-"A"
            if (chars[i] == 'A' && chars[i + 1] != 'A' && !swapped[i] && !swapped[i + 1]) {
                // Swap characters
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;

                // Mark positions as swapped
                swapped[i] = true;
                swapped[i + 1] = true;
                i++; // Skip the next character as it's already involved in a swap
            }
        }

        return new String(chars);
    }

    // Method to scramble words in a list and remove unchanged words
    public static void scrambleOrRemove(List<String> wordList) {
        Iterator<String> iterator = wordList.iterator();

        while (iterator.hasNext()) {
            String original = iterator.next();
            String scrambled = scrambleWord(original);

            // Remove unchanged words
            if (original.equals(scrambled)) {
                iterator.remove();
            } else {
                // Replace with scrambled version
                int index = wordList.indexOf(original);
                wordList.set(index, scrambled);
            }
        }
    }
}