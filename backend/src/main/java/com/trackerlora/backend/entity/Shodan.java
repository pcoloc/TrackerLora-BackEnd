package com.trackerlora.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "shodan")
public class Shodan {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private String name;

    private String apiKey;

    private String ownerUuid;

    private boolean isActive;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Shodan() {
    }

    public Shodan(String uuid, String name, String apiKey, String ownerUuid, boolean isActive) {
        this.uuid = uuid;
        this.name = name;
        this.apiKey = apiKey;
        this.ownerUuid = ownerUuid;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "shodan{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", ownerUuid='" + ownerUuid + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public Shodan(String uuid, String name, String apiKey, String ownerUuid) {
        this.uuid = uuid;
        this.name = name;
        this.apiKey = apiKey;
        this.ownerUuid = ownerUuid;
    }

    public Shodan(String name, String apiKey, String ownerUuid) {
        this.name = name;
        this.apiKey = apiKey;
        this.ownerUuid = ownerUuid;
    }

    public Shodan(String name, String apiKey) {
        this.name = name;
        this.apiKey = apiKey;
    }

    public Shodan(String name) {
        this.name = name;
    }



}
