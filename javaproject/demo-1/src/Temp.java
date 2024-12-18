public class Temp {
    public static void main(String[] args) {
        System.out.println(solution(1, 10));
//        System.out.println(solution(10, 20));
//        System.out.println(solution(5, 5));
    }

    public static int solution(int start, int end) {
        int count = 0;
        for (int num = start; num <= end; num++) {
            System.out.println(num + "확인 대상 숫자");
            if (num == 2) {
                count++;
                continue;
            } else if (num < 2) {
                continue;
            }
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {

                if (num % i == 0) {
                    System.out.println("소수가 아님");
                    flag = false;
                    break;
                }


            }
            if (flag) {
                count++;
            }
        }

        return count;
    }
}
