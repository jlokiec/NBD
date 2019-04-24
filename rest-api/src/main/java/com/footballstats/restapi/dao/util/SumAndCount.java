package com.footballstats.restapi.dao.util;

public class SumAndCount {
    private double sum;
    private long count;

    public SumAndCount(double sum, long count) {
        this.sum = sum;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
