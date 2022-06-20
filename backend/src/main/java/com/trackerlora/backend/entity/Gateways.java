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
    private String networkId;

    @Column(name = "gtw_id", nullable = true)
    private String gtwId;

    @Column(name = "gtw_eui", nullable = true)
    private String gtwEui;

    @Column(name = "antenna_index", nullable = true)
    private Integer antennaIndex;

    @Column(name = "time", nullable = true)
    private Long time;

    @Column(name = "timestamp", nullable = true)
    private Long timestamp;

    @Column(name = "channel", nullable = true)
    private Integer channel;

    @Column(name = "rssi", nullable = true)
    private Integer rssi;

    @Column(name = "snr", nullable = true)
    private Integer snr;

    @Column(name = "latitude", nullable = true)
    private Float latitude;

    @Column(name = "longitude", nullable = true)
    private Float longitude;

    @Column(name = "altitude", nullable = true)
    private Float altitude;

    @Column(name = "location_accuracy", nullable = true)
    private Float locationAccuracy;

    @Column(name = "location_source", nullable = true)
    private String locationSource;

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

    public String getGtwId() {
        return gtwId;
    }

    public void setGtwId(String gtwId) {
        this.gtwId = gtwId;
    }

    public String getGtwEui() {
        return gtwEui;
    }

    public void setGtwEui(String gtwEui) {
        this.gtwEui = gtwEui;
    }

    public Integer getAntennaIndex() {
        return antennaIndex;
    }

    public void setAntennaIndex(Integer antennaIndex) {
        this.antennaIndex = antennaIndex;
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

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public Integer getSnr() {
        return snr;
    }

    public void setSnr(Integer snr) {
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

    public Float getLocationAccuracy() {
        return locationAccuracy;
    }

    public void setLocationAccuracy(Float locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
    }

    public String getLocationSource() {
        return locationSource;
    }

    public void setLocationSource(String locationSource) {
        this.locationSource = locationSource;
    }

    @Override
    public String toString() {
        return "Gateways{" +
                "id=" + id +
                ", networkId='" + networkId + '\'' +
                ", gtwId='" + gtwId + '\'' +
                ", gtwEui='" + gtwEui + '\'' +
                ", antennaIndex=" + antennaIndex +
                ", time=" + time +
                ", timestamp=" + timestamp +
                ", channel=" + channel +
                ", rssi=" + rssi +
                ", snr=" + snr +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", locationAccuracy=" + locationAccuracy +
                ", locationSource='" + locationSource + '\'' +
                '}';
    }

    public Gateways(String networkId, String gtwId, String gtwEui, Integer antennaIndex, Long time, Long timestamp, Integer channel, Integer rssi, Integer snr, Float latitude, Float longitude, Float altitude, Float locationAccuracy, String locationSource) {
        this.networkId = networkId;
        this.gtwId = gtwId;
        this.gtwEui = gtwEui;
        this.antennaIndex = antennaIndex;
        this.time = time;
        this.timestamp = timestamp;
        this.channel = channel;
        this.rssi = rssi;
        this.snr = snr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.locationAccuracy = locationAccuracy;
        this.locationSource = locationSource;
    }

    public Gateways() {
    }

    public Gateways(String networkId, String gtwId, String gtwEui, Integer antennaIndex, Long time, Long timestamp, Integer channel, Integer rssi, Integer snr, Float latitude, Float longitude, Float altitude, Float locationAccuracy, String locationSource, Integer id) {
        this.networkId = networkId;
        this.gtwId = gtwId;
        this.gtwEui = gtwEui;
        this.antennaIndex = antennaIndex;
        this.time = time;
        this.timestamp = timestamp;
        this.channel = channel;
        this.rssi = rssi;
        this.snr = snr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.locationAccuracy = locationAccuracy;
        this.locationSource = locationSource;
        this.id = id;
    }

}
