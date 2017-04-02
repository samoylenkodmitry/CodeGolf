package com.samart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * "A" Марсианский волейбол
 * Ограничение по времени	2 секунды
 * Ограничение по памяти	256 мегабайт
 * Волейбольный матч на Марсе играется двумя командами до k очков, при этом для победы отрыв должен быть хотя бы на 2 очка. За каждый розыгрыш мяча одна из команд получает ровно 1 очко.
 * <p>
 * На текущий момент матча счет первой команды равен x, а счет второй команды равен y. Какое минимальное количество мячей будут разыграны до окончания матча?
 * <p>
 * <p>
 * Отправить решение
 * Формат входных данных
 * Входные данные содержат несколько тестовых наборов. В первой строке задано количество тестов t (1 ≤ t ≤ 5000).
 * <p>
 * Каждый тестовый пример описывается одной строкой, содержащей три целых числа, разделенных пробелами: k, x и y (1 ≤ k ≤ 100; 0 ≤ x, y ≤ 100).
 * <p>
 * Гарантируется, что счет мог быть получен при корректной незавершенной игре.
 * <p>
 * Формат выходных данных
 * Для каждого теста в отдельной строке выведите ответ на него — минимальное количество мячей, которые будут разыграны до окончания матча.
 * <p>
 * Примеры
 * Входные данные
 * 3
 * 2 1 0
 * 3 4 3
 * 5 0 0
 * Выходные данные
 * 1
 * 1
 * 5
 */
public class AA2017 {

    public static void main(String... args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            Integer[] digs = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            System.out.println(solve(digs[0], digs[1], digs[2]));
        }
    }

    private static int solve(int k, int x, int y) {
        int max = x > y ? x : y;
        int min = x > y ? y : x;
        int d = max - min;
        if (max < k) {
            int forwin = k-max;
            d = k - min;
            if (d >= 2) {
                return forwin;
            } else {
                return forwin + 2 - d;
            }
        } else {
            //2 3 5
            if (d >= 2) {
                return 0;
            } else {
                //2 3 4
                return 2 - d;
            }
        }
    }
}
