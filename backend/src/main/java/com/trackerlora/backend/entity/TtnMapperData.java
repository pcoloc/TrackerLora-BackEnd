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
//    "user_id":"58a83bbf-f5e9-4c92-ad3f-8523a58c8941",
//    "user_agent":"Android12 App34:2021.12.17"

@Entity
@Table(name = "ttnMapperData")
public class TtnMapperData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "network_id", nullable = true)
    private String network_id;

    @Column(name = "app_id", nullable = true)
    private String app_id;

    @Column(name = "dev_id", nullable = true)
    private String dev_id;

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
    private Integer spreading_factor;

    @Column(name = "coding_rate", nullable = true)
    private String coding_rate;

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
    private Float accuracy_meters;

    @Column(name = "accuracy_source", nullable = true)
    private String accuracy_source;

    @Column(name = "user_id", nullable = true)
    private String user_id;

    @Column(name = "user_agent", nullable = true)
    private String user_agent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetworkId() {
        return network_id;
    }

    public void setNetworkId(String network_id) {
        this.network_id = network_id;
    }

    public String getAppId() {
        return app_id;
    }

    public void setAppId(String app_id) {
        this.app_id = app_id;
    }

    public String getDevId() {
        return dev_id;
    }

    public void setDevId(String dev_id) {
        this.dev_id = dev_id;
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
        return spreading_factor;
    }

    public void setSpreadingFactor(Integer spreading_factor) {
        this.spreading_factor = spreading_factor;
    }

    public String getCodingRate() {
        return coding_rate;
    }

    public void setCodingRate(String coding_rate) {
        this.coding_rate = coding_rate;
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
        return accuracy_meters;
    }

    public void setAccuracyMeters(Float accuracy_meters) {
        this.accuracy_meters = accuracy_meters;
    }

    public String getAccuracySource() {
        return accuracy_source;
    }

    public void setAccuracySource(String accuracy_source) {
        this.accuracy_source = accuracy_source;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getUseragent() {
        return user_agent;
    }

    public void setUseragent(String user_agent) {
        this.user_agent = user_agent;
    }

    @Override
    public String toString() {
        return "TtnMapperData{" +
                "id=" + id +
                ", network_id='" + network_id + '\'' +
                ", app_id='" + app_id + '\'' +
                ", dev_id='" + dev_id + '\'' +
                ", time=" + time +
                ", port=" + port +
                ", counter=" + counter +
                ", frequency=" + frequency +
                ", modulation='" + modulation + '\'' +
                ", bandwidth=" + bandwidth +
                ", spreading_factor=" + spreading_factor +
                ", coding_rate='" + coding_rate + '\'' +
                ", gateways=" + gateways.toString() +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", accuracy_meters=" + accuracy_meters +
                ", accuracy_source='" + accuracy_source + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_agent='" + user_agent + '\'' +
                '}';
    }

    public TtnMapperData() {
    }



}
