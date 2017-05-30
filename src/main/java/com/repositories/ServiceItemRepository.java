package com.repositories;

import com.models.ServiceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItemEntity,Long> {
}
