public class Algo32 {
    public static void main(String[] args) {
        int answer = solution("hello", "l");
        System.out.println("answer = " + answer);
    }

    public static int solutionOld(String word, String c) {
        return word.replaceAll("[^"+c+"]", "").length();
    }
    public static int solution(String word, String c) {
        int answer = 0;
        char targer = c.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (targer == word.charAt(i)) {
                answer++;
            }
        }
        return answer;
    }
}
