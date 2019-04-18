package com.footballstats.restapi.dao.util;

import lombok.Data;

@Data
public class SumAndCount {
    private double sum;
    private long count;

    public SumAndCount(double sum, long count) {
        this.sum = sum;
        this.count = count;
    }
}
