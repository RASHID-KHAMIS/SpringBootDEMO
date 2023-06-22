package com.lib.Library.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zoneId;
    private String zoneName;
    private String zoneCode;
}
