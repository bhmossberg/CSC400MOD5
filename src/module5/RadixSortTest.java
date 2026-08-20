package module5;

public class RadixSortTest {
    public static void main(String[] args) {
        Integer[] data = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        RadixSort.sort(data);
        System.out.println("Sorted:   " + java.util.Arrays.toString(data));
    }
}