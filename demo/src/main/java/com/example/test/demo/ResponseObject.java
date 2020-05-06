package com.example.test.demo;

import org.springframework.context.annotation.Bean;


public class ResponseObject {
    private String blog;
    private String location;

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
