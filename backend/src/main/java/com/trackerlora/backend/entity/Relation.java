package com.trackerlora.backend.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "relations")
public class Relation {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private String client1Uuid;

    private String client2Uuid;

    private String lat1;

    private String lon1;

    private String lat2;

    private String lon2;

    private Date date;

    public Relation() {
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClient1Uuid() {
        return client1Uuid;
    }

    public void setClient1Uuid(String client1Uuid) {
        this.client1Uuid = client1Uuid;
    }

    public String getClient2Uuid() {
        return client2Uuid;
    }

    public void setClient2Uuid(String client2Uuid) {
        this.client2Uuid = client2Uuid;
    }

    public String getLat1() {
        return lat1;
    }

    public void setLat1(String lat1) {
        this.lat1 = lat1;
    }

    public String getLon1() {
        return lon1;
    }

    public void setLon1(String lon1) {
        this.lon1 = lon1;
    }

    public String getLat2() {
        return lat2;
    }

    public void setLat2(String lat2) {
        this.lat2 = lat2;
    }

    public String getLon2() {
        return lon2;
    }

    public void setLon2(String lon2) {
        this.lon2 = lon2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
