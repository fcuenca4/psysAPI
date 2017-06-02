package com.repositories;

import com.models.BlackWhiteListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecoratorRepository extends JpaRepository<BlackWhiteListEntity,Long> {
    List<BlackWhiteListEntity> findAllByBwlScbId(Long id);
    @Query("SELECT p FROM BlackWhiteListEntity p WHERE p.bwlId = :black_white_list_ID AND p.bwlScbId = :ScbId")
    BlackWhiteListEntity findByBwlIdAndBwlScbId(@Param("black_white_list_ID") Long black_white_listID ,@Param("ScbId")Long subscriberID);
}