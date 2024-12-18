import java.util.Arrays;

public class Algo53 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 1)));
    }

    public static int[] solutionOld(int[] numbers, int step) {
        // step에 따른 값을 받을 여분의 배열
        int[] tmp = new int[numbers.length];
        // 임시 배열을 위한 인덱스
        int j = 0;
        // i에 step 만큼 증가 시키면 입력 배열 순회
        for (int i = 0; i < numbers.length; i += step) {
            // 임시 배열에 값 추가
            tmp[j] = numbers[i];
            // 임시 배열 인덱스 증가
            j++;
        }
        // 임시 배열의 값 옮기기
        // 임시 배열에는 불필요한 기본값이 포함되어 있음
        int[] answer = new int[j];
        // 옮기기
//        for (int i = 0; i < j; i++) {
//            answer[i] = tmp[i];
//        }
        System.arraycopy(tmp, 0, answer, 0, j);
        return answer;
    }
    public static int[] solution(int[] numbers, int step) {
        int[] answer = new int[1 + (numbers.length - 1) / step];
        int idx = 0;
        for (int i = 0; i < numbers.length; i+=step) {
            answer[idx] = numbers[i];
        }
        return answer;
    }
}
