package com.lib.Library.service;

import com.lib.Library.dto.ZoneRequestDto;
import com.lib.Library.dto.ZoneResponseDto;
import com.lib.Library.entity.Zone;
import com.lib.Library.repository.ZoneRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ZoneServices {
    private final ZoneRepository zoneRepository;
    private final ModelMapper modelMapper;

    public ZoneResponseDto zoneAdd(ZoneRequestDto zoneRequestDto) {
        Zone zone = modelMapper.map(zoneRequestDto, Zone.class);
        zoneRepository.save(zone);
        ZoneResponseDto zoneResponseDto = modelMapper.map(zone, ZoneResponseDto.class);
        return  zoneResponseDto;
    }

    public List<ZoneResponseDto> getAll() {
        ZoneResponseDto zoneResponseDto = null;
        List<ZoneResponseDto> list = new ArrayList<>();
        for (Zone zone:zoneRepository.findAll()){
            zoneResponseDto = modelMapper.map(zone,ZoneResponseDto.class);
            list.add(zoneResponseDto);
        }
        return  list;
    }

    public ZoneResponseDto zoneEdit(int zoneId, ZoneRequestDto zoneRequestDto) {
        Optional<Zone> zone = zoneRepository.findById(zoneId);
        if(!zone.isPresent()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"This zone does not exist");
        }
        Zone zone1 = modelMapper.map(zoneRequestDto, Zone.class);
        zone1.setZoneId(zoneId);
        zoneRepository.save(zone1);
        ZoneResponseDto zoneResponseDto = modelMapper.map(zone, ZoneResponseDto.class);
        return  zoneResponseDto;
    }

    public ZoneResponseDto getById(int zoneId) {
        Optional<Zone> zone = zoneRepository.findById(zoneId);
        if(!zone.isPresent()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"This zone does not exist");
        }

        ZoneResponseDto zoneResponseDto = modelMapper.map(zone.get(), ZoneResponseDto.class);
        return  zoneResponseDto;
    }

    public List<ZoneResponseDto> getAllByName(String zoneName) {
        ZoneResponseDto zoneResponseDto = null;
        List<ZoneResponseDto> list = new ArrayList<>();
        for (Zone zone:zoneRepository.findByZoneName(zoneName)){
            zoneResponseDto = modelMapper.map(zone,ZoneResponseDto.class);
            list.add(zoneResponseDto);
        }
        return  list;
    }

    public List<ZoneResponseDto> getAllByCode(String zoneCode) {
        ZoneResponseDto zoneResponseDto = null;
        List<ZoneResponseDto> list = new ArrayList<>();
        for (Zone zone:zoneRepository.findByZoneCode(zoneCode)){
            zoneResponseDto = modelMapper.map(zone,ZoneResponseDto.class);
            list.add(zoneResponseDto);
        }
        return  list;
    }



}
