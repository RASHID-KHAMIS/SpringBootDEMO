package com.lib.Library.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
public class ZoneRequestDto {
    private String zoneName;
    private String zoneCode;
}
