package com.repositories;

import com.models.ZoneCellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ZoneCellRepository extends JpaRepository<ZoneCellEntity,Long>{
}
