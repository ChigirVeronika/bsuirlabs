package by.bsuir.sum.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Вероника on 14.04.2015.
 */
public class TestRegexp {
    public static final Pattern pattern = Pattern.compile
            ("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");

    public static void doMatchEmail(String word) {
        String output = "MemberSubmissionAddressing.Validation for \"" + word + "\"";
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches())
            output += " passed.";
        else
        output += " not passed.";
        System.out.println(output);
    }
}
