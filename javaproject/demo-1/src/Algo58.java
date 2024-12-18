import java.util.Arrays;

public class Algo58 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 1, 3)));
    }

    public static int[] solution(int[] numbers, int start, int end) {
        int[] answer = new int[end - start + 1];
        System.arraycopy(numbers, start, answer, 0, end - start + 1);
        return answer;
    }
}
