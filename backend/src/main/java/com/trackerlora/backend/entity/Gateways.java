package com.trackerlora.backend.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;

//    "gateways":[
//       {
//          "network_id":"NS_TTS_V3://ttn@000013",
//          "gtw_id":"dragino-pac",
//          "gtw_eui":"A84041FFFF21C284",
//          "antenna_index":0,
//          "time":1655739629845000000,
//          "timestamp":3218513291,
//          "channel":2,
//          "rssi":-89.0,
//          "snr":7.5,
//          "latitude":36.83021314913074,
//          "longitude":-2.405869862996042,
//          "altitude":20,
//          "location_accuracy":0,
//          "location_source":"SOURCE_REGISTRY"
//       }
//    ],

@Entity
@Table(name = "gateways")
public class Gateways {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "network_id", nullable = true)
    private String network_id;

    @Column(name = "gtw_id", nullable = true)
    private String gtw_id;

    @Column(name = "gtw_eui", nullable = true)
    private String gtw_eui;

    @Column(name = "antenna_index", nullable = true)
    private Integer antenna_index;

    @Column(name = "time", nullable = true)
    private Long time;

    @Column(name = "timestamp", nullable = true)
    private Long timestamp;

    @Column(name = "channel", nullable = true)
    private Integer channel;

    @Column(name = "rssi", nullable = true)
    private Double rssi;

    @Column(name = "snr", nullable = true)
    private Double snr;

    @Column(name = "latitude", nullable = true)
    private Float latitude;

    @Column(name = "longitude", nullable = true)
    private Float longitude;

    @Column(name = "altitude", nullable = true)
    private Float altitude;

    @Column(name = "location_accuracy", nullable = true)
    private Float location_accuracy;

    @Column(name = "location_source", nullable = true)
    private String location_source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(String network_id) {
        this.network_id = network_id;
    }

    public String getGtw_id() {
        return gtw_id;
    }

    public void setGtw_id(String gtw_id) {
        this.gtw_id = gtw_id;
    }

    public String getGtw_eui() {
        return gtw_eui;
    }

    public void setGtw_eui(String gtw_eui) {
        this.gtw_eui = gtw_eui;
    }

    public Integer getAntenna_index() {
        return antenna_index;
    }

    public void setAntenna_index(Integer antenna_index) {
        this.antenna_index = antenna_index;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public double getRssi() {
        return rssi;
    }

    public void setRssi(double rssi) {
        this.rssi = rssi;
    }

    public double getSnr() {
        return snr;
    }

    public void setSnr(double snr) {
        this.snr = snr;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Float getLocation_accuracy() {
        return location_accuracy;
    }

    public void setLocation_accuracy(Float location_accuracy) {
        this.location_accuracy = location_accuracy;
    }

    public String getLocation_source() {
        return location_source;
    }

    public void setLocation_source(String location_source) {
        this.location_source = location_source;
    }

    @Override
    public String toString() {
        return "Gateways{" +
                "id=" + id +
                ", network_id='" + network_id + '\'' +
                ", gtw_id='" + gtw_id + '\'' +
                ", gtw_eui='" + gtw_eui + '\'' +
                ", antenna_index=" + antenna_index +
                ", time=" + time +
                ", timestamp=" + timestamp +
                ", channel=" + channel +
                ", rssi=" + rssi +
                ", snr=" + snr +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", location_accuracy=" + location_accuracy +
                ", location_source='" + location_source + '\'' +
                '}';
    }

    public Gateways(String network_id, String gtw_id, String gtw_eui, Integer antenna_index, Long time, Long timestamp, Integer channel, Double rssi, Double snr, Float latitude, Float longitude, Float altitude, Float location_accuracy, String location_source) {
        this.network_id = network_id;
        this.gtw_id = gtw_id;
        this.gtw_eui = gtw_eui;
        this.antenna_index = antenna_index;
        this.time = time;
        this.timestamp = timestamp;
        this.channel = channel;
        this.rssi = rssi;
        this.snr = snr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.location_accuracy = location_accuracy;
        this.location_source = location_source;
    }

    public Gateways() {
    }

    public Gateways(String network_id, String gtw_id, String gtw_eui, Integer antenna_index, Long time, Long timestamp, Integer channel, Double rssi, Double snr, Float latitude, Float longitude, Float altitude, Float location_accuracy, String location_source, Integer id) {
        this.network_id = network_id;
        this.gtw_id = gtw_id;
        this.gtw_eui = gtw_eui;
        this.antenna_index = antenna_index;
        this.time = time;
        this.timestamp = timestamp;
        this.channel = channel;
        this.rssi = rssi;
        this.snr = snr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.location_accuracy = location_accuracy;
        this.location_source = location_source;
        this.id = id;
    }

}
