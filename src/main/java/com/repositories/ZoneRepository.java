package com.repositories;

import com.models.HomeZoneEntity;
import com.models.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface ZoneRepository extends JpaRepository<ZoneEntity,Long> {
}
