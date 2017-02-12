package com.samart;

import java.util.Arrays;

/**
 * http://codegolf.stackexchange.com/questions/109248/mathematics-is-fact-programming-is-not
 */
interface mathFactCodeNot {
    static void main(String... args) {
        Arrays.stream(
                new String[]{"0", "1", "0!", "1!", "!0", "!1", "!0!", "!1!", "0!!", "1!!", "!!0", "!!1", "!0!!", "!!!1", "!!!0!!!!", "!!!1!!!!"}
        ).map(
                s -> {
                    int l = s.length(), n = (l > 1 ? s.split("[01]")[0] : s).length();
                    return l < 2 ? s : (l - n < 2 && s.charAt(n) < '1') == n % 2 > 0 ? 1 : 0;
                }
        ).forEach(System.out::println);
    }
}
