import java.util.Arrays;

public class Algo54 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, -1)));
    }

    public static int[] solutionOld(int[] numbers, int direction) {
        int[] answer = new int[numbers.length];

        int offset = direction > 0 ? direction : numbers.length + direction;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i + offset) % numbers.length);
            answer[(i + offset) % numbers.length] = numbers[i];
        }
//        if (direction > 0)
//            for (int i = 0; i < numbers.length; i++) {
//                answer[(i + direction) % numbers.length] = numbers[i];
//            }
//        else
//            for (int i = 0; i < numbers.length; i++) {
//                answer[i] = numbers[(i - direction) % numbers.length];
//            }


        return answer;
    }
    public static int[] solution(int[] numbers, int direction) {
        int[] answer = new int[numbers.length];

//        int offset = direction > 0 ? direction : numbers.length + direction;

        for (int i = 0; i < numbers.length; i++) {
            int newIndex = (i + numbers.length + direction) % numbers.length;
            answer[newIndex] = numbers[i];
        }
        return answer;
    }
}
