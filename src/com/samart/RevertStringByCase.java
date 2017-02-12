package com.samart;

import java.util.Arrays;

/**
 * http://codegolf.stackexchange.com/questions/109755/more-fun-with-case-very-sensitive-strings/109791#109791
 */
interface RevertStringByCase {

    static void main(String[] args) {
        Arrays.stream(args).map(
                s -> new String(new Error() {
                    char[] o = s.toCharArray();
                    char c;
                    int b;

                    {
                        while (b++ < 2) for (int l = 0, r = o.length; l < r; l++) {
                            for (--r; r > l && f(r); r--) ;
                            for (; l < r && f(l); l++) ;
                            if (l < r) {
                                o[l] = o[r];
                                o[r] = c;
                            }
                        }
                    }

                    boolean f(int i) {
                        c = o[i];
                        return b > 1 ? !Character.isUpperCase(c) : !Character.isLowerCase(c);
                    }
                }.o)
        ).forEach(System.out::println);
    }
}
