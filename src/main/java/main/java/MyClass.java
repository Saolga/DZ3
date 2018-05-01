package main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyClass {
    public static void main(String[] args) throws FileNotFoundException {
        /*Задание: есть входной файл с набором слов, написанных через пробел.
        Необходимо: Прочитать слова из файла, отсортировать в алфавитном порядке.
        Посчитать сколько раз каждое слово встречается в файле, вывести статистику на консоль.
        Найти слово с максимальным количеством повторений и вывести его и сколько раз оно встречается в
        файле.
        Реализация: одно слово, написанное в разных регистрах,
        воспринимается как два разных слова.
        */

        Scanner sc=new Scanner(new File("D:\\fordocument.txt"));    //тут путь к файлу

        Map<String, Integer> words = new TreeMap<>();   //сразу сортирует
        while (sc.hasNext()) {
            String word = sc.useDelimiter("\\s+").next();
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, ++count);
        }
        System.out.println(words);  //выводим статистику на консоль

        Integer maxKey=Collections.max(words.values()); //находим максимальное значение из ключей
        for (Map.Entry<String, Integer> entry : words.entrySet())   // проход по всем элементам
            if (entry.getValue()== maxKey)
                System.out.println(entry);     // печатаем элементы с максимальным числом повторений

        sc.close();
    }
}
