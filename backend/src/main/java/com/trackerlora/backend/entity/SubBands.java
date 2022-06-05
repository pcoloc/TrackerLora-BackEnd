package com.trackerlora.backend.entity;

import javax.persistence.Embeddable;

@Embeddable
public class SubBands {
    private String max_frequency;
    private String downlink_utilization_limit;

    public String getMaxFrequency() {
        return max_frequency;
    }

    public void setMaxFrequency(String max_frequency) {
        this.max_frequency = max_frequency;
    }

    public String getDownlinkUtilizationLimit() {
        return downlink_utilization_limit;
    }

    public void setDownlinkUtilizationLimit(String downlink_utilization_limit) {
        this.downlink_utilization_limit = downlink_utilization_limit;
    }

    @Override
    public String toString() {
        return "SubBands{" +
                "max_frequency='" + max_frequency + '\'' +
                ", downlink_utilization_limit='" + downlink_utilization_limit + '\'' +
                '}';
    }

    public SubBands() {
    }

    public SubBands(String max_frequency, String downlink_utilization_limit) {
        this.max_frequency = max_frequency;
        this.downlink_utilization_limit = downlink_utilization_limit;
    }


}
