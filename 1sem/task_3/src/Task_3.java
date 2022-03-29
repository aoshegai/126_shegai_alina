public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int count = 0;
        int cn1 = n1;
        if (n1 > n2) {
            n1 = n2;
            n2 = cn1;
        }
        for (int i = n1; i <= n2; i++) {
            if ((i % a == 0) && (i % b != 0)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int sum = 0;
        for (int i = 1; i <= num; i++){
            for (int j = 1; j <= i; j++) {
                sum++;
                if (sum == num) {
                    return i;
                }
            }
        }
        return sum;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int a = num;
        int sum = 0;
        for (int i = 1; i <=cnt; i++) {
            sum = sum + a;
            a = a * d + 1;
        }
        return sum;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int f = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++){
            f = f * i;
            sum += f;
        }
        return sum;
    }
}
