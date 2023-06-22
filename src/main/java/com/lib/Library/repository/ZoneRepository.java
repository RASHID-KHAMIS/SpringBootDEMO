package com.lib.Library.repository;

import com.lib.Library.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    List<Zone> findByZoneName(String zoneName);

    @Query(value = "SELECT * from zone where zone_code=?1",nativeQuery = true)
    List<Zone> findByZoneCode(String zoneConde);
}
