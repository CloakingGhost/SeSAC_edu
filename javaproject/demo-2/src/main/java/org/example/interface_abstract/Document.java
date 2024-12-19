package org.example.interface_abstract;

public abstract class Document {
    // 자식이 직접 접근 가능
    protected final String title;
    // getter 로 접근가능
//    private String title;

    // 자식이 직접 값을 바꿀 수 없음
    // 사람이 볼 때 어떤 의미의 차이가 있을까?
    // 관례적으로 직접 값에 접근한다
    // 이는 캡슐화에 위배되기 때문인가?


    protected final String ICBN;
    protected boolean isLend; // 빌려주었는가 // borrow 빌리다

    public Document(String title, String ICBN) {
        this.title = title;
        this.ICBN = ICBN;
        this.isLend = false;
    }

    public abstract void returnItem();
    public abstract void lendItem();
}
