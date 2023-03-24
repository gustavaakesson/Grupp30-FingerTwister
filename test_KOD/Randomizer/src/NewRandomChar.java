import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewRandomChar {

    public static void main(String[] args){
        Character[] arr = {'a','s','d','f','g','h','j','k'};
        List<Character> charList = Arrays.asList(arr);
        Collections.shuffle(charList);
        System.out.println(charList);
    }
}



