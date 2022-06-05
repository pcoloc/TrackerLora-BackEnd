package com.trackerlora.backend.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//The json received is this:
// //{
// "connected_at": "2022-06-02T08:41:39.624738941Z",
// "protocol": "udp",
// "last_uplink_received_at": "2022-06-05T11:15:49.158050520Z",
// "uplink_count": "5685",
// "last_downlink_received_at": "2022-06-02T17:55:14.885729340Z",
// "downlink_count": "1",
// "round_trip_times": {
//     "min": "0.057712751s",
//     "max": "0.057712751s",
//     "median": "0.057712751s",
//     "count": 1
// },
// "sub_bands": [
//     {
//         "max_frequency": "18446744073709551615",
//         "downlink_utilization_limit": 1
//     }
// ]
// }


@Entity
@Table(name = "statsTTN")
public class StatsTTN {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private String clientId;

    private Date connected_at;
    private String protocol;
    private Date last_uplink_received_at;
    private Integer uplink_count;
    private Date last_downlink_received_at;
    private Integer downlink_count;
    @Embedded
    private RoundTripTimes round_trip_times;

    @Embedded
    private SubBands sub_bands;

    public String getUuid() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }



    public Date getConnectedAt() {
        return connected_at;
    }

    public void setConnectedAt(Date connected_at) {
        this.connected_at = connected_at;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Date getLastUplinkReceivedAt() {
        return last_uplink_received_at;
    }

    public void setLastUplinkReceivedAt(Date last_uplink_received_at) {
        this.last_uplink_received_at = last_uplink_received_at;
    }

    public Integer getUplinkCount() {
        return uplink_count;
    }

    public void setUplinkCount(Integer uplink_count) {
        this.uplink_count = uplink_count;
    }

    public Date getLastDownlinkReceivedAt() {
        return last_downlink_received_at;
    }

    public void setLastDownlinkReceivedAt(Date last_downlink_received_at) {
        this.last_downlink_received_at = last_downlink_received_at;
    }

    public Integer getDownlinkCount() {
        return downlink_count;
    }

    public void setDownlinkCount(Integer downlink_count) {
        this.downlink_count = downlink_count;
    }

    public RoundTripTimes getRoundTripTimes() {
        return round_trip_times;
    }

    public void setRoundTripTimes(RoundTripTimes round_trip_times) {
        this.round_trip_times = round_trip_times;
    }

    public SubBands getSubBands() {
        return sub_bands;
    }

    public void setSubBands(SubBands sub_bands) {
        this.sub_bands = sub_bands;
    }

    @Override
    public String toString() {
        return "StatsTTN{" +
                "uuid='" + uuid + '\'' +
                "clientId='" + clientId + '\'' +
                ", connected_at='" + connected_at + '\'' +
                ", protocol='" + protocol + '\'' +
                ", last_uplink_received_at='" + last_uplink_received_at + '\'' +
                ", uplink_count='" + uplink_count + '\'' +
                ", last_downlink_received_at='" + last_downlink_received_at + '\'' +
                ", downlink_count='" + downlink_count + '\'' +
                ", round_trip_times='" + round_trip_times + '\'' +
                ", sub_bands='" + sub_bands + '\'' +
                '}';
    }

    public StatsTTN() {
    }

    public StatsTTN(String clientId, String clientApiKey, Date connected_at, String protocol, Date last_uplink_received_at, Integer uplink_count, Date last_downlink_received_at, Integer downlink_count, RoundTripTimes round_trip_times, SubBands sub_bands) {
        this.clientId = clientId;
        this.connected_at = connected_at;
        this.protocol = protocol;
        this.last_uplink_received_at = last_uplink_received_at;
        this.uplink_count = uplink_count;
        this.last_downlink_received_at = last_downlink_received_at;
        this.downlink_count = downlink_count;
        this.round_trip_times = round_trip_times;
        this.sub_bands = sub_bands;
    }
}


