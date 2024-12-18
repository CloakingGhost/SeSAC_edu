public class Algo33 {
    public static void main(String[] args) {
        int answer = solution("algorithm");
        System.out.println("answer = " + answer);
    }

    public static int solutionOld(String word) {
        int answer = 0;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++answer;
            }
        }

        return answer;
    }
    public static int solution(String word) {
        return word.replaceAll("[^aeiou]", "").length();
    }
}
