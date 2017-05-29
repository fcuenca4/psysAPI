package com.controllers.util;


public class ResponseDATA<T> {
    private T data;
    private int count;

    public ResponseDATA(T data, int count) {
        this.data = data;
        this.count = count;
    }
    public ResponseDATA(T data) {
        this.data = data;
        this.count = 1;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDATA<?> that = (ResponseDATA<?>) o;
        if (count != that.count) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

}
