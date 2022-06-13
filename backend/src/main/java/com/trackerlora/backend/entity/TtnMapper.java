package com.trackerlora.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "ttnmapper")
public class TtnMapper {
    //the id is called index
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer index;

    private Integer uid;

    private String Session;

    private String DevID;

    private Integer Time;

    private Integer FPort;

    private Integer FCount;

    private Integer Frecuency;

    private Integer Bandwidth;

    private Integer SpreadingFactor;

    private String CodingRate;

    private String GatewayID;

    private Integer AntennaIndex;

    private Integer GatewayTime;

    private Integer GatewayTimestamp;

    private Integer ChannelIndex;

    private Integer Rssi;

    private Integer Snr;

    private float GatewayLatitude;

    private float GatewayLongitude;

    private Integer GatewayAltitude;

    private float Latitude;

    private float Longitude;

    private float Altitude;

    private float AccuracyMetters;

    //Getter and Setter methods are automatically generated
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String session) {
        Session = session;
    }

    public String getDevID() {
        return DevID;
    }

    public void setDevID(String devID) {
        DevID = devID;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public Integer getFPort() {
        return FPort;
    }

    public void setFPort(Integer fPort) {
        FPort = fPort;
    }

    public Integer getFCount() {
        return FCount;
    }

    public void setFCount(Integer fCount) {
        FCount = fCount;
    }

    public Integer getFrecuency() {
        return Frecuency;
    }

    public void setFrecuency(Integer frecuency) {
        Frecuency = frecuency;
    }

    public Integer getBandwidth() {
        return Bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        Bandwidth = bandwidth;
    }

    public Integer getSpreadingFactor() {
        return SpreadingFactor;
    }

    public void setSpreadingFactor(Integer spreadingFactor) {
        SpreadingFactor = spreadingFactor;
    }

    public String getCodingRate() {
        return CodingRate;
    }

    public void setCodingRate(String codingRate) {
        CodingRate = codingRate;
    }

    public String getGatewayID() {
        return GatewayID;
    }

    public void setGatewayID(String gatewayID) {
        GatewayID = gatewayID;
    }

    public Integer getAntennaIndex() {
        return AntennaIndex;
    }

    public void setAntennaIndex(Integer antennaIndex) {
        AntennaIndex = antennaIndex;
    }

    public Integer getGatewayTime() {
        return GatewayTime;
    }

    public void setGatewayTime(Integer gatewayTime) {
        GatewayTime = gatewayTime;
    }

    public Integer getGatewayTimestamp() {
        return GatewayTimestamp;
    }

    public void setGatewayTimestamp(Integer gatewayTimestamp) {
        GatewayTimestamp = gatewayTimestamp;
    }

    public Integer getChannelIndex() {
        return ChannelIndex;
    }

    public void setChannelIndex(Integer channelIndex) {
        ChannelIndex = channelIndex;
    }

    public Integer getRssi() {
        return Rssi;
    }

    public void setRssi(Integer rssi) {
        Rssi = rssi;
    }

    public Integer getSnr() {
        return Snr;
    }

    public void setSnr(Integer snr) {
        Snr = snr;
    }

    public float getGatewayLatitude() {
        return GatewayLatitude;
    }

    public void setGatewayLatitude(float gatewayLatitude) {
        GatewayLatitude = gatewayLatitude;
    }

    public float getGatewayLongitude() {
        return GatewayLongitude;
    }

    public void setGatewayLongitude(float gatewayLongitude) {
        GatewayLongitude = gatewayLongitude;
    }

    public Integer getGatewayAltitude() {
        return GatewayAltitude;
    }

    public void setGatewayAltitude(Integer gatewayAltitude) {
        GatewayAltitude = gatewayAltitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getAltitude() {
        return Altitude;
    }

    public void setAltitude(float altitude) {
        Altitude = altitude;
    }

    public float getAccuracyMetters() {
        return AccuracyMetters;
    }

    public void setAccuracyMetters(float accuracyMetters) {
        AccuracyMetters = accuracyMetters;
    }

    @Override
    public String toString() {
        return "TtnMapper [index=" + index + ", uid=" + uid + ", Session=" + Session + ", DevID=" + DevID + ", Time="
                + Time + ", FPort=" + FPort + ", FCount=" + FCount + ", Frecuency=" + Frecuency + ", Bandwidth="
                + Bandwidth + ", SpreadingFactor=" + SpreadingFactor + ", CodingRate=" + CodingRate + ", GatewayID="
                + GatewayID + ", AntennaIndex=" + AntennaIndex + ", GatewayTime=" + GatewayTime + ", GatewayTimestamp="
                + GatewayTimestamp + ", ChannelIndex=" + ChannelIndex + ", Rssi=" + Rssi + ", Snr=" + Snr
                + ", GatewayLatitude=" + GatewayLatitude + ", GatewayLongitude=" + GatewayLongitude
                + ", GatewayAltitude=" + GatewayAltitude + ", Latitude=" + Latitude + ", Longitude=" + Longitude
                + ", Altitude=" + Altitude + ", AccuracyMetters=" + AccuracyMetters + "]";
    }

    public TtnMapper(Integer index, Integer uid, String session, String devID, Integer time, Integer fPort,
            Integer fCount, Integer frecuency, Integer bandwidth, Integer spreadingFactor, String codingRate,
            String gatewayID, Integer antennaIndex, Integer gatewayTime, Integer gatewayTimestamp, Integer channelIndex,
            Integer rssi, Integer snr, float gatewayLatitude, float gatewayLongitude, Integer gatewayAltitude,
            float latitude, float longitude, float altitude, float accuracyMetters) {
        super();
        this.index = index;
        this.uid = uid;
        Session = session;
        DevID = devID;
        Time = time;
        FPort = fPort;
        FCount = fCount;
        Frecuency = frecuency;
        Bandwidth = bandwidth;
        SpreadingFactor = spreadingFactor;
        CodingRate = codingRate;
        GatewayID = gatewayID;
        AntennaIndex = antennaIndex;
        GatewayTime = gatewayTime;
        GatewayTimestamp = gatewayTimestamp;
        ChannelIndex = channelIndex;
        Rssi = rssi;
        Snr = snr;
        GatewayLatitude = gatewayLatitude;
        GatewayLongitude = gatewayLongitude;
        GatewayAltitude = gatewayAltitude;
        Latitude = latitude;
        Longitude = longitude;
        Altitude = altitude;
        AccuracyMetters = accuracyMetters;
    }

    public TtnMapper() {
    }

}
