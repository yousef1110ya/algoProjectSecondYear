import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplitter {

    public static void main(String[] args) {
        String input = "(A[20,10] | (B[20,10]|C[30,10])) – (D[30,50] | (E[40,30] – F[40,20]))";

        // Extract character-number pairs using regular expression
        Pattern pattern = Pattern.compile("([A-Z])\\[(\\d+),(\\d+)\\]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String character = matcher.group(1);
            int width = Integer.parseInt(matcher.group(2));
            int height = Integer.parseInt(matcher.group(3));

            // Create the separate string for each character
            String result = character + " [" + width + "," + height + "]";
            System.out.println(result);
        }
    }
}
