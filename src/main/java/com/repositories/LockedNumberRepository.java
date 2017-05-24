package com.repositories;

import com.models.LockedNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockedNumberRepository extends JpaRepository<LockedNumberEntity,Integer> {
}

