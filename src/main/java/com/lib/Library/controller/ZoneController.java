package com.lib.Library.controller;

import com.lib.Library.dto.ZoneRequestDto;
import com.lib.Library.service.ZoneServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("zone")
@Data
@CrossOrigin
@RestController
public class ZoneController {
    @Autowired
    private final ZoneServices zoneServices;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody ZoneRequestDto zoneRequestDto){
        return ResponseEntity.ok(zoneServices.zoneAdd(zoneRequestDto));
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(zoneServices.getAll());
    }
    @RequestMapping(value = "/{zoneId}",method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable("zoneId") int zoneId,@RequestBody ZoneRequestDto zoneRequestDto){
        return ResponseEntity.ok(zoneServices.zoneEdit(zoneId,zoneRequestDto));
    }
    @RequestMapping(value = "/{zoneId}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("zoneId") int zoneId){
        return ResponseEntity.ok(zoneServices.getById(zoneId));
    }

    @RequestMapping(value = "get-zone-name/{zoneName}",method = RequestMethod.GET)
    public ResponseEntity getByZoneName(@PathVariable("zoneName") String zoneName){
        return ResponseEntity.ok(zoneServices.getAllByName(zoneName));
    }

    @RequestMapping(value = "get-zone-code/{zoneCode}",method = RequestMethod.GET)
    public ResponseEntity getByZoneCode(@PathVariable("zoneCode") String zoneCode){
        return ResponseEntity.ok(zoneServices.getAllByCode(zoneCode));
    }

}
