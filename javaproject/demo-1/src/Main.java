public class Main {
    public static void main(String[] args) {
        String name = "kule";
        int age = 20; // ctrl shift enter
        boolean isMail = true;

        System.out.println(name);
        System.out.println(age);
        System.out.println(isMail);

        byte byteType = 1;
        short shortType = 20;
        int intType = 300;
        long longType = 400_000L;

        float floatType = 1.1f;
        double doubleType1 = 2.2d;
        double doubleType2 = 2.2;

        char charType = 'A';

        boolean booleanType1 = true;
        boolean booleanType2 = false;

        int bigNumber1 = 200_000_000;
        int bigNumber2 = 200_000_000;
        System.out.println(bigNumber1 + bigNumber2);

//        형변환
        // 작은 용량의 데이터를 큰 용량의 데이터로
        int intType2 = 10000;
        long longType2 = (long) intType2;

        System.out.println(longType2);

        // 큰 용량의 데이터를 작은 용량의 데이터로
        // 데이터 유실 가능성이 있음
        long longType3 = 10_000_000_000L;
        int intType3 = (int) longType3;


    }
}