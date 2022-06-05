package com.trackerlora.backend.entity;

import javax.persistence.Embeddable;

@Embeddable
public class RoundTripTimes {
    private String min;
    private String max;
    private String median;
    private String count;

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RoundTripTimes{" +
                "min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", median='" + median + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public RoundTripTimes() {
    }

    public RoundTripTimes(String min, String max, String median, String count) {
        this.min = min;
        this.max = max;
        this.median = median;
        this.count = count;
    }

}
