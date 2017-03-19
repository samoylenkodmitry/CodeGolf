package com.samart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/**
 * http://www.russiancodecup.ru/ru/championship/
 *
 *
 *
 * "A" Космический корабль
 Ограничение по времени	2 секунды
 Ограничение по памяти	256 мегабайт
 Космический рейнджер оказался на инопланетном космическом корабле в окружении врагов. Чтобы освободиться, ему необходимо уничтожить всех врагов в определенном порядке.

 Вокруг рейнджера n врагов, i-й из них обладает силой fi. Чтобы выбраться, рейнджеру необходимо уничтожить всех врагов, причем в таком порядке, чтобы сила последнего уничтоженного врага была равна сумме всех остальных врагов.

 В запасе у рейнджера мало времени, так что он не успевает понять, как это сделать. Ему необходима ваша помощь. Восстановите порядок, в котором необходимо уничтожать врагов, чтобы выбраться.

 Формат входных данных
 В первой строке ввода находится натуральное число n — количество врагов (2 ≤ n ≤ 105).

 Во второй строке находятся n целых чисел fi, задающих силу каждого врага ( - 109 ≤ fi ≤ 109).

 Формат выходных данных
 Выведите числа fi в порядке, в котором необходимо уничтожать соответствующих им врагов. Если существует несколько подходящих вариантов, выведите любой. Гарантируется, что хотя бы один подходящий порядок уничтожения существует.

 Примеры
 Входные данные
 3
 2 5 3
 Выходные данные
 2 3 5
 Входные данные
 5
 -1 1 0 1 -1
 Выходные данные
 -1 1 1 -1 0
 Попытка 150:36	Runtime Error
 test=1
 Попытка 21:30:45	Accepted
 test=5
 */
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
