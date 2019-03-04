package com.example.inmobiliaria.Retrofit.Responses;

import java.util.List;
import java.util.Objects;

public class ResponseContainer<T> {

    private List<T> rows;
    private long count;

    public ResponseContainer() { }

    public ResponseContainer(List<T> rows, long count) {
        this.rows = rows;
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseContainer)) return false;
        ResponseContainer<?> that = (ResponseContainer<?>) o;
        return count == that.count &&
                Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, count);
    }

    @Override
    public String toString() {
        return "ResponseContainer{" +
                "rows=" + rows +
                ", count=" + count +
                '}';
    }
}
