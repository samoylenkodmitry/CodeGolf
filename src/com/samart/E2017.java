package com.samart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.russiancodecup.ru/ru/championship/
 * <p>
 * <p>
 * <p>
 * "E" Параллелепипед
 * Ограничение по времени	2 секунды
 * Ограничение по памяти	256 мегабайт
 * Черный Рейнджер хочет составить прямоугольный параллелепипед. Для этого он планирует использовать 6 из n прямоугольных листов металла, i-й лист имеет размер ai на bi метров.
 * <p>
 * Каждая грань параллелепипеда должна представлять собой цельный лист металла. Листы нельзя гнуть или разрезать, листы, из которых будет сложен параллелепипед, не должны выступать за его края. Листы можно поворачивать произвольным образом.
 * <p>
 * Черный Рейнджер хочет построить параллелепипед максимального объема. Помогите ему.
 * <p>
 * <p>
 * Отправить решение
 * Формат входных данных
 * В первой строке дано одно число n — количество листов металла у Черного Рейнджера (6 ≤ n ≤ 200 000).
 * <p>
 * В следующих n строках даны пары чисел ai, bi — размеры i-го листа металла (1 ≤ ai, bi ≤ 106).
 * <p>
 * Формат выходных данных
 * Выведите одно целое число — максимальный объем прямоугольного параллелепипеда, который можно собрать из этих листов металла.
 * <p>
 * Если из данных листов невозможно собрать прямоугольный параллелепипед, выведите  - 1.
 * <p>
 * Примеры
 * Входные данные
 * 6
 * 3 6
 * 6 9
 * 9 3
 * 6 3
 * 3 9
 * 9 6
 * Выходные данные
 * 162
 * Входные данные
 * 6
 * 1 1
 * 1 1
 * 1 1
 * 1 1
 * 1 1
 * 1 1
 * Выходные данные
 * 1
 * Входные данные
 * 6
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 6 1
 */
public class E2017 {
    public static void main(String... args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(in.readLine());

        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            Integer[] wh = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            ps[i] = new P();
            ps[i].w = Math.max(wh[0], wh[1]);
            ps[i].h = Math.min(wh[0], wh[1]);
        }

        int v = calcVolume(ps);
        System.out.println(v);
    }

    /**
     *   * *      |  * *
     *   * *      |  * *
     *
     *   * * * *  |  * * * *
     *   * * * *  |  * * * *
     *
     *   * * * *  |  * * * *
     *   * * * *  |  * * * *
     *   ___________________
     *
     *   * * *    |  * * *
     *   * * *    |  * * *
     *
     *   * * * *  |  * * * *
     *   * * * *  |  * * * *
     *   * * * *  |  * * * *
     *
     *   * * * *  |  * * * *
     *   * * * *  |  * * * *
     *
     */

    Map<Integer, List<P>> removeEqualHeights(List<P> twoCopies){
        return null;
    }
    List<P> twoCopies(P[] ps){return null;}

    private static int calcVolume(P[] ps) {
        Map<Integer, List<P>> ws = new HashMap<>();
        Map<Integer, List<P>> hs= new HashMap<>();
        fill(ws,hs, ps);

        for (Integer h: hs.keySet()) {
            List<P> ww = hs.get(h);
        }

        return 0;
    }

    private static void fill(Map<Integer, List<P>> ws, Map<Integer, List<P>> hs, P[] ps) {

    }

    static class P {
        int w, h;
    }
}
