package com.repositories;

import com.models.ServiceClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/serviceclass")
public interface ServiceClassRepository extends JpaRepository<ServiceClassEntity,Long>{}
