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
                s ->
                        new String(new Error() {
                            int l = s.length();
                            String p = l > 1 ? s.split("[01]")[0] : s;
                            int n = p.length();

                            {
                                if (l > 1)
                                    p = (l - n > 1 || s.charAt(n) == '1') == n % 2 > 0 ? "0" : "1";
                            }
                        }.p)
        ).forEach(System.out::println);
    }
}
