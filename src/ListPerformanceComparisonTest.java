import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListPerformanceComparisonTest {
    private static final int TEST_SIZE =10000;

    @Test
    public void testArrayListPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }
        long durationAdd = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.get(i);
        }
        long durationGet = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.remove(0);
        }
        long durationRemove = System.nanoTime() - startTime;
        System.out.printf("ArrayList - add: %d ns, get: %d ns, remove: %d ns%n", durationAdd, durationGet, durationRemove);
    }
    @Test
    public void testLinkedListPerformance() {
        List<Integer> linkedList = new LinkedList<>();

        // Test add
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }
        long durationAdd = System.nanoTime() - startTime;

        // Test get
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.get(i);
        }
        long durationGet = System.nanoTime() - startTime;

        // Test remove
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.remove(0);
        }
        long durationRemove = System.nanoTime() - startTime;

        System.out.printf("LinkedList - add: %d ns, get: %d ns, remove: %d ns%n", durationAdd, durationGet, durationRemove);
    }
}