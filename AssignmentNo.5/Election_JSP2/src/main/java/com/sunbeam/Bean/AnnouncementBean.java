package com.sunbeam.Bean;

public class AnnouncementBean {
    private String ann;
    private String message;

    public String getAnn() {
        return ann;
    }

    public void setAnn(String ann) {
        this.ann = ann;
        setMessage(ann);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
