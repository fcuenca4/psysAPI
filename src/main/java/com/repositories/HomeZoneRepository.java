package com.repositories;

import com.models.HomeZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/homezone")
public interface HomeZoneRepository extends JpaRepository<HomeZoneEntity,Long> {
}
