package com.repositories;

import com.models.LockedNumberEntity;
import com.models.SubscriberEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockedNumberRepository extends JpaRepository<LockedNumberEntity,Long> {
    List<LockedNumberEntity> findAllByLckScbId(Long id);
    @Query("SELECT p FROM LockedNumberEntity p WHERE p.lckId = :lckId AND p.lckScbId = :ScbId")
    LockedNumberEntity findByLckIdAndLckScbId( @Param("lckId")Long lckId,@Param("ScbId") Long ScbId);
    LockedNumberEntity findFirstByLckDn(Long LckDn);

}

