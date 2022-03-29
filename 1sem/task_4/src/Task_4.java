import java.util.Arrays;

public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] ap = new int[size];
        ap[0] = a0;
        for (int i = 1; i < size; i++) {
            ap[i] = ap[0] + d * i;
        }
        return ap;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] sum = new int[size];
        sum[0] = 1;
        if (size > 1) {
            sum[1] = 1;
            for (int i = 2; i < size; i++) {
                sum[i] = sum[i - 1] * 2;
            }
        }
        return sum;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int[] fib = new int[size];
        fib[0] = 0;
        if (size > 1) {
            fib[1] = 1;
            for (int i = 2; i < size; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max = -214783648;
        for (int i = 1; i < data.length; i++) {
            if ((data[i] > max) && (data[i] % k == 0)) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int[] sa = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            sa[i] = arr1 [i];
        }
        for (int i = 0; i < arr2.length; i++) {
            sa[arr1.length + i] = arr2 [i];
        }
        Arrays.sort(sa);
        return sa;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        /*int[] sa = new int[arr1.length + arr2.length];
        int l1 = 0;
        int l2 = 0;
        int i = 0;
        while ((l1 < arr1.length) || (l2 < arr2.length)) {
            if ((l2 >= arr2.length) || ((l1 < arr1.length) && (arr1[l1] < arr2[l2]))) {
                sa[i] = arr1[l1];
                l1++;
            } else {
                sa[i] = arr2[l2];
                l2++;
            }
            i++;
        }
        return sa;*/
        int[] sa = new int[arr1.length + arr2.length];
        int l1 = 0;
        int l2 = 0;
        int i = 0;
        while (i < (arr1.length + arr2.length)) {
            if ((l2 >= arr2.length) || ((l1 < arr1.length) && (arr1[l1] < arr2[l2]))) {
                sa[i] = arr1[l1];
                l1++;
            } else {
                sa[i] = arr2[l2];
                l2++;
            }
            i++;
        }
        return sa;
    }
}
