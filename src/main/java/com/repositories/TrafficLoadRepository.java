package com.repositories;

import com.models.TrafficLoadDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrafficLoadRepository extends JpaRepository<TrafficLoadDiscountEntity,Long> {
}
