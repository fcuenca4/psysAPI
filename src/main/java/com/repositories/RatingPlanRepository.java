package com.repositories;

import com.models.RatingPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/ratingplan")
public interface RatingPlanRepository extends JpaRepository<RatingPlanEntity,Long> {
}
