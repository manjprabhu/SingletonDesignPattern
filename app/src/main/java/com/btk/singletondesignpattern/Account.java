package com.btk.singletondesignpattern;

public class Account {

    private static Account INSTANCE;

    private Account() {
    }

    public static Account getInstance() {
        if (INSTANCE == null) {
            synchronized (Account.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Account();
                }
            }
        }
        return INSTANCE;
    }
}
