import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaGenerics {
    public static void main(String[] args) {
        List<Integer> int_array = new ArrayList<>(Arrays.asList(3,5 ,8));
        int_array.add(11);
        int_array.add(1);

        for (int i : int_array) {
            System.out.println(i );
        }

        // Using map

        List<Integer> int_array2 = int_array.stream().map(elem -> {
            System.out.println("map: " + elem);
            return elem + 1;
        }).sorted((elem1, elem2) -> {
            return elem1.compareTo(elem2);
        }).toList();

        for (int i : int_array2) {
            System.out.println(i );
        }
    }

}