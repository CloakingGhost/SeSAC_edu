package org.example.prac4accessmodifier;


/* 사용자(개발자)가 사용하는 것만 열어둔다 */
public class PrivateModifier {
    public int publicNum = 1;
    // 외부에서 직접 건들지 못함
    private int privateNum = 10;

    // 간접적으로 접근 불가한 데이터를 볼 수 있음
    public int getPrivateNum() {
        return privateNum;
    }

    // 데이터 변화에 대한 트래킹이 가능하다
    // 메소드 스택에서 확인 가능
    // 사용하는 함수를 눌러 어떤 함수인지 확인 가능
    public void setPrivateNum(int privateNum) {
        this.privateNum = privateNum;
    }

    public void publicHi() {
        System.out.println("hi. public");
    }

    private void privateHi() {
        System.out.println("hi. private");
    }

    public void sayHi(){
        privateHi();
    }

}
