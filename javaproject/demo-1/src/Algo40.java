public class Algo40 {
    public static void main(String[] args) {
        int answer = solution("aaaa", "aa");
        System.out.println(answer);
    }

    public static int solution(String word, String target) {
        int answer = 0;

        if (!word.contains(target)) return 0;

        for (int i = 0; i < word.length() - target.length() + 1; i++) {
            boolean isSame = true;

            for (int j = 0; j < target.length(); j++) {

                if (word.charAt(i + j) != target.charAt(j)) {
                    isSame = false;
                    break;
                }

            }


            if (isSame) {
                ++answer;
            }

        }
        return answer;
    }

    public static int solutionOld(String word, String target) {
        int answer = 0;

        if (!word.contains(target)) return 0;

        for (int i = 0; i < word.length(); i++) {
            boolean isSame = true;
            int j = 0;
            for (; j < target.length(); j++) {
                if (i + j < word.length() && word.charAt(i + j) != target.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if (i + j <= word.length() && isSame) {
                ++answer;
            }

        }
        return answer;
    }
}
