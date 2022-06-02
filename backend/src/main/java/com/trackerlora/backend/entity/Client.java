package com.trackerlora.backend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    private boolean isRouter;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Location> locations;

    private String apiKey;

    private String ownerUuid;

    private boolean isPublic;

    private String color;

    private boolean isActive;




    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isRouter() {
        return isRouter;
    }

    public void setRouter(boolean isRouter) {
        this.isRouter = isRouter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Client() {

    }

    public Client(String uuid, boolean isRouter, String name, String description, List<Location> locations, String apiKey, String ownerUuid, boolean isPublic, String color, boolean isActive) {
        this.uuid = uuid;
        this.isRouter = isRouter;
        this.name = name;
        this.description = description;
        this.locations = locations;
        this.apiKey = apiKey;
        this.ownerUuid = ownerUuid;
        this.isPublic = isPublic;
        this.color = color;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Client [uuid=" + uuid + ", isRouter=" + isRouter + ", name=" + name + ", description=" + description
                + ", locations=" + locations + ", apiKey=" + apiKey + ", ownerUuid=" + ownerUuid + ", isPublic="
                + isPublic + ", color=" + color + ", isActive=" + isActive + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((locations == null) ? 0 : locations.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownerUuid == null) ? 0 : ownerUuid.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (apiKey == null) {
            if (other.apiKey != null)
                return false;
        } else if (!apiKey.equals(other.apiKey))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (locations == null) {
            if (other.locations != null)
                return false;
        } else if (!locations.equals(other.locations))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (ownerUuid == null) {
            if (other.ownerUuid != null)
                return false;
        } else if (!ownerUuid.equals(other.ownerUuid))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }



}
