package com.repositories;
import com.models.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/servicetype")
 public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity,Long> {
}
