package com.example.lab6;

public class Usage {
    int page;
    int count;
    String id;

    Usage(String id) {
        this.id = id;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }
}
