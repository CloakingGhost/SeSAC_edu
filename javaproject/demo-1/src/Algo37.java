public class Algo37 {

    public static void main(String[] args) {
        String answer = solution("hello", 1, 3);
        System.out.println("answer = " + answer);
    }

    public static String solution(String word, int start, int end) {
        return word.substring(start, end + 1);
    }


}
