package com.trackerlora.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="power")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "device_power", nullable = true)
    private Integer device_power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevice_power() {
        return device_power;
    }

    public void setDevice_power(Integer device_power) {
        this.device_power = device_power;
    }

    @Override
    public String toString(){
        return this.device_power.toString();
    }

    public Power(Integer device_power){
        this.device_power = device_power;
    }

    public Power(){
    }
}
