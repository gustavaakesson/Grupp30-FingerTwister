import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewIntegerRandom {

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 3, 5, 555, 34, 345, 2222, 324, 45, 5, 67};
        List<Integer> keyCodeList = Arrays.asList(arr);
        Collections.shuffle(keyCodeList);
        System.out.println(keyCodeList);
    }
}

