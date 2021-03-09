package com.verinite.dummyInterestApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.dummyInterestApp.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
