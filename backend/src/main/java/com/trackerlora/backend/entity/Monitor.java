package com.trackerlora.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "monitors")
public class Monitor {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private String name;

    private boolean isActive;

    private String description;

    private String ip;

    private String ownerUuid;


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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public Monitor() {
    }

    public Monitor(String uuid, String name, boolean isActive, String description, String ip, String ownerUuid) {
        this.uuid = uuid;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.ip = ip;
        this.ownerUuid = ownerUuid;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", ownerUuid='" + ownerUuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monitor monitor = (Monitor) o;

        if (isActive != monitor.isActive) return false;
        if (uuid != null ? !uuid.equals(monitor.uuid) : monitor.uuid != null) return false;
        if (name != null ? !name.equals(monitor.name) : monitor.name != null) return false;
        if (description != null ? !description.equals(monitor.description) : monitor.description != null) return false;
        if (ip != null ? !ip.equals(monitor.ip) : monitor.ip != null) return false;
        return ownerUuid != null ? ownerUuid.equals(monitor.ownerUuid) : monitor.ownerUuid == null;
    }

    @Override
    public int hashCode() {
        Integer result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (ownerUuid != null ? ownerUuid.hashCode() : 0);
        return result;
    }



}
