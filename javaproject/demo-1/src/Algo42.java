public class Algo42 {
    public static void main(String[] args) {
        String answer = solution("banana", "a");
        System.out.println("answer = " + answer);
    }

    public static String solution(String word, String target) {
        return word.replace(target, "");
    }
}
