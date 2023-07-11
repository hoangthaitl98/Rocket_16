package com.example.shopping.utils;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final Pattern NOVIETNAMESE = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public String createSlug(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        String noWhitespace = WHITESPACE.matcher(temp).replaceAll("-");
        String slug = NOVIETNAMESE.matcher(noWhitespace).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public String toUppercaseNoSpace(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        String noWhitespace = WHITESPACE.matcher(temp).replaceAll("_");
        String value = NOVIETNAMESE.matcher(noWhitespace).replaceAll("")
                .replace('đ', 'd').replace('Đ', 'D')
                .toUpperCase(Locale.ENGLISH);
        return value;
    }
}
