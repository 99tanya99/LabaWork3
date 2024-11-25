import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для сравнения производительности различных реализаций списков
 * Сравниваются методы add,get, remove для ArrayList и LinkedList
 */
public class ListPerformanceComparison{
    public static final int TEST_SIZE = 10000;

    /**
     * Метод запуска программы
     * @param args аргументы командной строки(не используются)
     */
    public static void main(String[] args){
        System.out.printf("%-15s %-10s %-15s %-15s%n", "Метод", "Количество", "Время (нс)", "Тип списка");
        System.out.println("-----------------------------------------------------");
        compareListPerformance(new ArrayList<>(),"ArrayList");
        compareListPerformance(new LinkedList<>(),"LinkedList");
    }

    /**
     * Сравнивает производительности методов add,get, remove для заданног списка
     * @param list Коллекция для тестирования
     * @param listType Тип коллекциии
     */
    private static void compareListPerformance(List<Integer> list, String listType){
        //тест метода add
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        long duration = System.nanoTime() - startTime;
        System.out.printf("%-15s %-10d %-15d %-15s%n", "add", TEST_SIZE, duration, listType);
        //тест метода get
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.get(i);
        }
        duration = System.nanoTime() - startTime;
        System.out.printf("%-15s %-10d %-15d %-15s%n", "get", TEST_SIZE, duration, listType);
        //тест метода remove
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.remove(0);
        }
        duration = System.nanoTime() - startTime;
        System.out.printf("%-15s %-10d %-15d %-15s%n", "get", TEST_SIZE, duration, listType);
    }

}