import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < data.size(); i++) {
            if ((data.get(i) % k == 0) && (data.get(i) % n != 0)) {
                list.add(data.get(i));
            }
        }
        return list;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 1; i <= size; i++){
            for (int j = 1; j <= i; j++){
                sum++;
                list.add(i);
                if (sum == size){
                    return list;
                }
            }
        }
        return list;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        HashSet<Integer> array = new HashSet<Integer>();
        for (int i : s1) {
            for (int j : s2) {
                if (i == j) array.add(i);
            }
        }
        return array;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> extra = new HashSet<Integer>();
        for (int i : s2) {
            if (!s1.contains(i)) {
                extra.add(i);
            }
        }
        return extra;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> array = new HashSet<Integer>();
        for (int i : s1) {
            if (!s2.contains(i)) {
                array.add(i);
            }
        }
        for (int i : s2) {
            if (!s1.contains(i)) {
                array.add(i);
            }
        }
        return array;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> percentage = new HashMap<>();
        double p;
        for (int i = 0; i < data.size(); i++) {
            p = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(i) == data.get(j)) {
                    p++;
                }
                percentage.put(data.get(i), p/data.size()*100);
            }
        }
        return percentage;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> mmm = new HashMap<>();
        double mean = 0;
        double max = data.get(0);
        double min = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (max < data.get(i)) {
                max = data.get(i);
            }
            if (min > data.get(i)) {
                min = data.get(i);
            }
            mean += data.get(i);
        }
        mean = mean/data.size();
        mmm.put("mean", mean);
        mmm.put("max", max);
        mmm.put("min", min);
        return mmm;
    }
}
