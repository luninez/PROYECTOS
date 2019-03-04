package com.example.inmobiliaria.Retrofit.Responses;

import java.util.Objects;

public class ResponseContainerOneRow<T> {

    private T rows;
    private long count;

    public ResponseContainerOneRow(){ }

    public ResponseContainerOneRow(T rows, long count) {
        this.rows = rows;
        this.count = count;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
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
        if (!(o instanceof ResponseContainerOneRow)) return false;
        ResponseContainerOneRow<?> that = (ResponseContainerOneRow<?>) o;
        return count == that.count &&
                Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, count);
    }

    @Override
    public String toString() {
        return "ResponseContainerOneRow{" +
                "rows=" + rows +
                ", count=" + count +
                '}';
    }
}
