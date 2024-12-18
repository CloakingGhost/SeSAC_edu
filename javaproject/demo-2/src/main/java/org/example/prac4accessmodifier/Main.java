package org.example.prac4accessmodifier;

import org.example.prac4accessmodifier.tmp.DefaultModifier;

public class Main {
    public static void main(String[] args) {
        PrivateModifier pm = new PrivateModifier();
        System.out.println(pm.publicNum);
//        System.out.println(pm.privateNum); // 에러 private
        System.out.println(pm.getPrivateNum());
        pm.setPrivateNum(100);
        System.out.println(pm.getPrivateNum());

        pm.publicHi();
//        pm.privateHi(); // 에러 private
        pm.sayHi();

        DefaultModifier dm = new DefaultModifier();

        System.out.println(dm.publicString);
//        System.out.println(dm.defaultString); // 에러 default

    }
}
