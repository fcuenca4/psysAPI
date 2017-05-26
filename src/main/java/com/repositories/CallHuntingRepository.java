package com.repositories;

import com.models.CallHuntingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallHuntingRepository extends JpaRepository<CallHuntingEntity,Long> {
    List<CallHuntingEntity> findAllByChtScbId(Long id);
    @Query("SELECT p FROM CallHuntingEntity p WHERE p.chtId = :ChtId AND p.chtScbId = :ScbId")
    CallHuntingEntity findByChtIdAndChtScbId(@Param("ScbId") Long ScbId, @Param("ChtId")Long lckId);
}

