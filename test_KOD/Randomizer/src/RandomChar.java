import java.util.Random;

public class RandomChar {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        Random rand = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        System.out.println(arr);
    }
}
