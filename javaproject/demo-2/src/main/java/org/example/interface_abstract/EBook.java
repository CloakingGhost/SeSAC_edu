package org.example.interface_abstract;

public class EBook extends Document implements Downloadable {

    public EBook(String title, String ICBN) {
        super(title, ICBN);
    }

    @Override
    public void returnItem() {

    }

    @Override
    public void lendItem() {

    }


    @Override
    public void download() {
        System.out.println(title + " 다운로드 완료");
    }
}
