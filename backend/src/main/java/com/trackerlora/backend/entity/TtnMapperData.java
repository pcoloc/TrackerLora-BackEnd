package com.trackerlora.backend.entity;

import com.trackerlora.backend.entity.Gateways;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.OneToMany;

// "network_id":"NS_TTS_V3://ttn@000013",
//    "app_id":"aplicacionpaco",
//    "dev_id":"heltec-v2",
//    "time":1655739586422000000,
//    "port":10,
//    "counter":1,
//    "frequency":868500000,
//    "modulation":"LORA",
//    "bandwidth":125000,
//    "spreading_factor":7,
//    "coding_rate":"4/5",
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
//    "latitude":36.83086373,
//    "longitude":-2.40480238,
//    "altitude":48.3681640625,
//    "accuracy_meters":3.7900924682617188,
//    "accuracy_source":"gps",
//    "userid":"58a83bbf-f5e9-4c92-ad3f-8523a58c8941",
//    "useragent":"Android12 App34:2021.12.17"

@Entity
@Table(name = "ttnMapperData")
public class TtnMapperData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "network_id", nullable = true)
    private String networkId;

    @Column(name = "app_id", nullable = true)
    private String appId;

    @Column(name = "dev_id", nullable = true)
    private String devId;

    @Column(name = "time", nullable = true)
    private Long time;

    @Column(name = "port", nullable = true)
    private Integer port;

    @Column(name = "counter", nullable = true)
    private Integer counter;

    @Column(name = "frequency", nullable = true)
    private Integer frequency;

    @Column(name = "modulation", nullable = true)
    private String modulation;

    @Column(name = "bandwidth", nullable = true)
    private Integer bandwidth;

    @Column(name = "spreading_factor", nullable = true)
    private Integer spreadingFactor;

    @Column(name = "coding_rate", nullable = true)
    private String codingRate;

    @Column(name = "gateways", nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Gateways> gateways;

    @Column(name = "latitude", nullable = true)
    private Float latitude;

    @Column(name = "longitude", nullable = true)
    private Float longitude;

    @Column(name = "altitude", nullable = true)
    private Float altitude;

    @Column(name = "accuracy_meters", nullable = true)
    private Float accuracyMeters;

    @Column(name = "accuracy_source", nullable = true)
    private String accuracySource;

    @Column(name = "userid", nullable = true)
    private String userid;

    @Column(name = "useragent", nullable = true)
    private String useragent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getSpreadingFactor() {
        return spreadingFactor;
    }

    public void setSpreadingFactor(Integer spreadingFactor) {
        this.spreadingFactor = spreadingFactor;
    }

    public String getCodingRate() {
        return codingRate;
    }

    public void setCodingRate(String codingRate) {
        this.codingRate = codingRate;
    }

    public List<Gateways> getGateways() {
        return gateways;
    }

    public void setGateways(List<Gateways> gateways) {
        this.gateways = gateways;
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

    public Float getAccuracyMeters() {
        return accuracyMeters;
    }

    public void setAccuracyMeters(Float accuracyMeters) {
        this.accuracyMeters = accuracyMeters;
    }

    public String getAccuracySource() {
        return accuracySource;
    }

    public void setAccuracySource(String accuracySource) {
        this.accuracySource = accuracySource;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    @Override
    public String toString() {
        return "TtnMapperData{" +
                "id=" + id +
                ", networkId='" + networkId + '\'' +
                ", appId='" + appId + '\'' +
                ", devId='" + devId + '\'' +
                ", time=" + time +
                ", port=" + port +
                ", counter=" + counter +
                ", frequency=" + frequency +
                ", modulation='" + modulation + '\'' +
                ", bandwidth=" + bandwidth +
                ", spreadingFactor=" + spreadingFactor +
                ", codingRate='" + codingRate + '\'' +
                ", gateways=" + gateways.toString() +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", accuracyMeters=" + accuracyMeters +
                ", accuracySource='" + accuracySource + '\'' +
                ", userid='" + userid + '\'' +
                ", useragent='" + useragent + '\'' +
                '}';
    }

    public TtnMapperData() {
    }



}
