package com.repositories;

import com.models.BlackWhiteListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecoratorRepository extends JpaRepository<BlackWhiteListEntity,Long> {
    List<BlackWhiteListEntity> findAllByBwlScbId(Long id);
}

