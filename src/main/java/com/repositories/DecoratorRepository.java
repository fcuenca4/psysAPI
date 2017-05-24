package com.repositories;

import com.models.BlackWhiteListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecoratorRepository extends JpaRepository<BlackWhiteListEntity,Integer> {
}

