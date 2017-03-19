package com.samart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class A2017 {
    public static void main(String... args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(in.readLine());
        String[] split = in.readLine().split(" ");
        Object[] objects = Arrays.stream(split).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] powers = (Integer[]) objects;

        if (n <= 0) throw new Exception(" 0 n");
        if (powers == null || powers.length == 0) throw new Exception(" 0 powers");

        Integer[] result = calcOrder(n, powers);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(s -> sb.append(sb.length() == 0 ? "" : " ").append(s));
        System.out.println(sb);
    }


    private static Integer[] calcOrder(int n, Integer[] powers) {
        // -2 1 0  3
        // -2 3 0  1
        //  4 1 1 -1
        Integer z = count(powers, 0);
        if (Objects.equals(z, powers[0])) {
            swap(powers, 0, n - 1);
        } else {
            for (int i = 1; i < n; i++) {
                z = z - powers[i] + powers[i - 1];
                if (Objects.equals(z, powers[i])) {
                    swap(powers, i, n - 1);
                    break;
                }
            }
        }
        return powers;
    }

    private static Integer count(Integer[] powers, int i) {
        Integer sum = 0;
        for (int j = 0; j < powers.length; j++) {
            if (j != i) {
                sum += powers[j];
            }
        }
        return sum;
    }

    private static void swap(Integer[] powers, int mp, int i) {
        Integer t = powers[mp];
        powers[mp] = powers[i];
        powers[i] = t;
    }
}
