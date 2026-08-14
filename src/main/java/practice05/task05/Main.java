package practice05.task05;

import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> list = FileParser.parseFile("src/main/webapp/WEB-INF/sample.txt");
        String searchFor = "dog";
        Pattern pattern = Pattern.compile(searchFor);
        List<String> results = list.stream().filter(pattern.asPredicate()).toList();
        String result = (results.isEmpty()) ? "Not found." : "Number of times encountered: ";
        System.out.print("Word {" + searchFor + "}. " + result);
        System.out.println(results.size());
    }
}
