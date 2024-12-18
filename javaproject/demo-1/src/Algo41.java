public class Algo41 {
    public static void main(String[] args) {
        String answer = solution("banana split", "banana", "apple");
        System.out.println("answer = " + answer);
    }

    public static String solution(String word, String oldString, String newString) {
        StringBuilder sb = new StringBuilder(word);
        int idx = sb.indexOf(oldString);
        sb.delete(idx, idx + oldString.length())
                .insert(idx, newString);
        return sb.toString();
    }
}
