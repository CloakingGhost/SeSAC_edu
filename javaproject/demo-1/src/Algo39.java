public class Algo39 {

    public static void main(String[] args) {
        boolean answer = solution("racecar");
        System.out.println("answer = " + answer);
    }

    public static boolean solution(String word) {
        boolean answer = true;
        char[] charArray = word.toCharArray();
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (charArray[l] != charArray[r]) {
                answer = false;
                break;
            }
            ++l;
            --r;
        }

        return answer;
    }

    public static boolean solutionOld(String word) {
        boolean answer = true;
        char[] charArray = word.toCharArray();

        for (int left = 0; left < word.length() / 2; left++) {
            int right = word.length() - 1 - left;
            if (charArray[left] != charArray[right]) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
