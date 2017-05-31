package com.repositories;
import com.models.CellEntity;
import com.models.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Repository
public interface CellRepository extends JpaRepository<CellEntity,Long> {
}
