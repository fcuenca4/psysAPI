package com.repositories;
import com.models.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/language")
public interface LanguageRepository extends JpaRepository<LanguageEntity,Long> {
}
