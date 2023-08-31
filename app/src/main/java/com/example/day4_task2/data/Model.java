package com.example.day4_task2.data;

public class Model {

    private final String mobile;
    private final String message;

    public Model(String mobile, String message) {
        this.mobile = mobile;
        this.message = message;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMessage() {
        return message;
    }

}
