import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        int number = 10;

        int[] numbers1;
        numbers1 = new int[5];

        int[] numbers2;
        numbers2 = new int[]{1, 2, 3, 4, 5};

        int[] numbers3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.toString(numbers3));

        System.out.println(numbers2 == numbers3);
        System.out.println(Arrays.equals(numbers2, numbers3));

        System.out.println(numbers2.length);


        char[] chars = new char[]{'a', 'b', 'c', 'd'};

        for (int i = 0; i < chars.length; i++) {
            char el = chars[i];
            System.out.println("el = " + el);
        }

        for (char el : chars) {
            System.out.println("enhance for loop: el = " + el);
        }

    }
}
