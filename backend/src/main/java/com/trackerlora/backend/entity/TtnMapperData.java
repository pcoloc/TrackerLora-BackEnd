package com.trackerlora.backend.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;


@Entity
@Table(name = "ttnMapperData")
public class TtnMapperData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable=true)
    private Integer uid;

    @Column(nullable=true)
    private String session;

    @Column(nullable=true)
    private String app_id;

    @Column(nullable=true)
    private String dev_id;

    @Column(nullable=true)
    private String dev_eui;

    @Column(nullable=true)
    private String time;

    @Column(nullable=true)
    private Integer fPort;

    @Column(nullable=true)
    private Integer fCount;

    @Column(nullable=true)
    private Long frequency;

    @Column(nullable=true)
    private String modulation;

    @Column(nullable=true)
    private Long bandwidth;

    @Column(nullable=true)
    private Integer spreading_factor;

    @Column(nullable=true)
    private String bitrate;

    @Column(nullable=true)
    private String coding_rate;

    @Column(nullable=true)
    private String gateway_id;

    @Column(nullable=true)
    private String gateway_eui;

    @Column(nullable=true)
    private Integer antenna_index;

    @Column(nullable=true)
    private String gateway_time;

    @Column(nullable=true)
    private Long gateway_timestamp;

    @Column(nullable=true)
    private Long fine_timestamp;

    @Column(nullable=true)
    private Long fine_timestamp_encrypted;

    @Column(nullable=true)
    private String fine_timestamp_encrypted_key_id;

    @Column(nullable=true)
    private Integer channel_index;

    @Column(nullable=true)
    private Float Rssi;

    @Column(nullable=true)
    private String signal_Rssi;

    @Column(nullable=true)
    private String snr;

    @Column(nullable=true)
    private Float gateway_latitude;

    @Column(nullable=true)
    private Float gateway_longitude;

    @Column(nullable=true)
    private Float gateway_altitude;

    @Column(nullable=true)
    private Float gateway_location_accuracy;

    @Column(nullable=true)
    private String gateway_location_source;

    @Column(nullable=true)
    private Float latitude;

    @Column(nullable=true)
    private Float longitude;

    @Column(nullable=true)
    private Float altitude;

    @Column(nullable=true)
    private Float accuracy_meters;

    @Column(nullable=true)
    private Integer satellites;

    @Column(nullable=true)
    private String hdop;

    @Column(nullable=true)
    private String accuracy_source;

    @Column(nullable=true)
    private String experiment;

    @Column(nullable=true)
    private String user_id;

    @Column(nullable=true)
    private String user_agent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getDev_eui() {
        return dev_eui;
    }

    public void setDev_eui(String dev_eui) {
        this.dev_eui = dev_eui;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getFPort() {
        return fPort;
    }

    public void setFPort(Integer fPort) {
        this.fPort = fPort;
    }

    public Integer getFCount() {
        return fCount;
    }

    public void setFCount(Integer fCount) {
        this.fCount = fCount;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public String getModulation() {
        return modulation;
    }

    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getSpreading_factor() {
        return spreading_factor;
    }

    public void setSpreading_factor(Integer spreading_factor) {
        this.spreading_factor = spreading_factor;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getCoding_rate() {
        return coding_rate;
    }

    public void setCoding_rate(String coding_rate) {
        this.coding_rate = coding_rate;
    }

    public String getGateway_id() {
        return gateway_id;
    }

    public void setGateway_id(String gateway_id) {
        this.gateway_id = gateway_id;
    }

    public String getGateway_eui() {
        return gateway_eui;
    }

    public void setGateway_eui(String gateway_eui) {
        this.gateway_eui = gateway_eui;
    }

    public Integer getAntenna_index() {
        return antenna_index;
    }

    public void setAntenna_index(Integer antenna_index) {
        this.antenna_index = antenna_index;
    }

    public String getGateway_time() {
        return gateway_time;
    }

    public void setGateway_time(String gateway_time) {
        this.gateway_time = gateway_time;
    }

    public Long getGateway_timestamp() {
        return gateway_timestamp;
    }

    public void setGateway_timestamp(Long gateway_timestamp) {
        this.gateway_timestamp = gateway_timestamp;
    }

    public Long getFine_timestamp() {
        return fine_timestamp;
    }

    public void setFine_timestamp(Long fine_timestamp) {
        this.fine_timestamp = fine_timestamp;
    }

    public Long getFine_timestamp_encrypted() {
        return fine_timestamp_encrypted;
    }

    public void setFine_timestamp_encrypted(Long fine_timestamp_encrypted) {
        this.fine_timestamp_encrypted = fine_timestamp_encrypted;
    }

    public String getFine_timestamp_encrypted_key_id() {
        return fine_timestamp_encrypted_key_id;
    }

    public void setFine_timestamp_encrypted_key_id(String fine_timestamp_encrypted_key_id) {
        this.fine_timestamp_encrypted_key_id = fine_timestamp_encrypted_key_id;
    }

    public Integer getChannel_index() {
        return channel_index;
    }

    public void setChannel_index(Integer channel_index) {
        this.channel_index = channel_index;
    }

    public Float getRssi() {
        return Rssi;
    }

    public void setRssi(Float Rssi) {
        this.Rssi = Rssi;
    }

    public String getSignal_Rssi() {
        return signal_Rssi;
    }

    public void setSignal_Rssi(String signal_Rssi) {
        this.signal_Rssi = signal_Rssi;
    }

    public String getSnr() {
        return snr;
    }

    public void setSnr(String snr) {
        this.snr = snr;
    }

    public Float getGateway_latitude() {
        return gateway_latitude;
    }

    public void setGateway_latitude(Float gateway_latitude) {
        this.gateway_latitude = gateway_latitude;
    }

    public Float getGateway_longitude() {
        return gateway_longitude;
    }

    public void setGateway_longitude(Float gateway_longitude) {
        this.gateway_longitude = gateway_longitude;
    }

    public Float getGateway_altitude() {
        return gateway_altitude;
    }

    public void setGateway_altitude(Float gateway_altitude) {
        this.gateway_altitude = gateway_altitude;
    }

    public Float getGateway_location_accuracy() {
        return gateway_location_accuracy;
    }

    public void setGateway_location_accuracy(Float gateway_location_accuracy) {
        this.gateway_location_accuracy = gateway_location_accuracy;
    }

    public String getGateway_location_source() {
        return gateway_location_source;
    }

    public void setGateway_location_source(String gateway_location_source) {
        this.gateway_location_source = gateway_location_source;
    }

    public Float getLatitude () {
        return latitude;
    }

    public void setLatitude (Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude () {
        return longitude;
    }

    public void setLongitude (Float longitude) {
        this.longitude = longitude;
    }

    public Float getAltitude () {
        return altitude;
    }

    public void setAltitude (Float altitude) {
        this.altitude = altitude;
    }

    public Float getAccuracy_meters () {
        return accuracy_meters;
    }

    public void setAccuracy_meters (Float accuracy_meters) {
        this.accuracy_meters = accuracy_meters;
    }

    public Integer getSatellites () {
        return satellites;
    }

    public void setSatellites (Integer satellites) {
        this.satellites = satellites;
    }

    public String getHdop () {
        return hdop;
    }

    public void setHdop (String hdop) {
        this.hdop = hdop;
    }

    public String getAccuracy_source() {
        return accuracy_source;
    }

    public void setAccuracy_source(String accuracy_source) {
        this.accuracy_source = accuracy_source;
    }

    public String getExperiment() {
        return experiment;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }

    public String getUser_id () {
        return user_id;
    }

    public void setUser_id (String user_id) {
        this.user_id = user_id;
    }

    public String getUser_agent () {
        return user_agent;
    }

    public void setUser_agent (String user_agent) {
        this.user_agent = user_agent;
    }

    public TtnMapperData() {

    }

    @Override
    public String toString() {
        return "TtnMapperData{" +
                "gateway_id='" + gateway_id + '\'' +
                ", gateway_eui='" + gateway_eui + '\'' +
                ", antenna_index='" + antenna_index + '\'' +
                ", gateway_time='" + gateway_time + '\'' +
                ", gateway_timestamp='" + gateway_timestamp + '\'' +
                ", fine_timestamp='" + fine_timestamp + '\'' +
                ", fine_timestamp_encrypted='" + fine_timestamp_encrypted + '\'' +
                ", fine_timestamp_encrypted_key_id='" + fine_timestamp_encrypted_key_id + '\'' +
                ", channel_index='" + channel_index + '\'' +
                ", Rssi='" + Rssi + '\'' +
                ", signal_Rssi='" + signal_Rssi + '\'' +
                ", snr='" + snr + '\'' +
                ", gateway_latitude='" + gateway_latitude + '\'' +
                ", gateway_longitude='" + gateway_longitude + '\'' +
                ", gateway_altitude='" + gateway_altitude + '\'' +
                ", gateway_location_accuracy='" + gateway_location_accuracy + '\'' +
                ", gateway_location_source='" + gateway_location_source + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", altitude='" + altitude + '\'' +
                ", accuracy_meters='" + accuracy_meters + '\'' +
                ", satellites='" + satellites + '\'' +
                ", hdop='" + hdop + '\'' +
                ", accuracy_source='" + accuracy_source + '\'' +
                ", experiment='" + experiment + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_agent='" + user_agent + '\'' + '}';
    }

}
