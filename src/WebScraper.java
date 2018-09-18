import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(text);
        String[] words = text.split(" ");
        System.out.println("Total words: " + words.length);
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        Set set = new HashSet<String>(Arrays.asList(words));
        System.out.println("Unique words: " + set.size());
    }
}
