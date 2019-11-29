import java.util.Arrays;
import java.util.Vector;
import java.util.stream.IntStream;

public class WordBreak {
    private final Trie dictionary;

    private WordBreak() {
        dictionary = new Trie();
    }

    private void breakWord(final String str) {
        breakWord(str, str.length(), "");
    }

    private void breakWord(final String str, int n, String result) {
        for (int i = 0; i < n; i++) {
            String prefix = str.substring(0, i + 1);
            if (isWord(prefix)) {
                if (i == n) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                breakWord(str.substring(i, n - i), n - i, result + prefix + " ");
            }
        }
    }

    private boolean breakWorddp(final String str) {
        final int size = str.length();
        if (size == 0) {
            return true;
        }

        Vector<Boolean> wb = new Vector<>(size + 1);
        IntStream.range(0, size).forEach(n -> wb.add(false));

        for (int i = 0; i < size; i++) {
            if (!wb.get(i) && isWord(str.substring(0, i + 1))) {
                wb.set(i, true);
            }

            if (wb.get(i)) {
                if (i == size-1) {
                    return true;
                }

                for (int j = i; j < size; j++) {
                    final String word = str.substring(i, j - i + 1);
                    if (!wb.get(i) && isWord(word)) {
                        wb.set(i, true);
                    }
                    if (j == size-1 && wb.get(j)) {
                        return true;
                    }
                }
            }
        }

        wb.forEach(b -> System.out.println(" " + b));
        return false;
    }

    private boolean isWord(final String word) {
        return dictionary.search(word);
    }

    private boolean canBeBrokenUp(final String str) {
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            final String prefix = str.substring(0, i);
            if (isWord(prefix) && canBeBrokenUp(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private void insertWord(final String word) {
        dictionary.insert(word);
    }

    private void testWordBreak() {
        final String [] dictionary = {
                "mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "love", "ice", "cream"
        };

        Arrays.stream(dictionary).forEach(this::insertWord);

        System.out.println("First DP Test: is ");
        if (breakWorddp("iloveicecreamandmango"))
            System.out.println("pass.");
        else
            System.out.println("fail.");

        System.out.println("\nSecond DP Test: ");
        if (breakWorddp("ilovesamsungmobile"))
            System.out.println("pass.");
        else
            System.out.println("fail.");

        System.out.println("\nThird DP Test: ");
        if (breakWorddp("thiswillfail"))
            System.out.println("pass.");
        else
            System.out.println("fail.");

        System.out.println("First Test: ");
        breakWord("iloveicecreamandmango");

        System.out.println("\nSecond Test:");
        breakWord("ilovesamsungmobile");
    }

    // Word Break Problem
    private void testWordBreak2() {

        final String [] dictionary = {"this", "th", "is", "famous", "word", "break",
                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"};

        Arrays.stream(dictionary).forEach(this::insertWord);

        if (canBeBrokenUp("wordbreakproblem"))
            System.out.println("String can be segmented");
        else
            System.out.println("String can't be segmented");

        if (canBeBrokenUp("wordbreakproblemx"))
            System.out.println("String can be segmented");
        else
            System.out.println("String can't be segmented");
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        wb.testWordBreak();
        wb.testWordBreak2();
    }
}
