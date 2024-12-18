public class Algo57 {
    public static void main(String[] args) {

    }
    public static int[] solution(int[] numbers, int n) {
        int[] answer = new int[numbers.length * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < numbers.length; j++) {
                answer[i * numbers.length + j] = numbers[j];
            }
        }



        return answer;
    }
}
