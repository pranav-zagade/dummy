package com.verinite.dummyInterestApp.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.verinite.dummyInterestApp.model.Plan;
import com.verinite.dummyInterestApp.repository.PlanRepository;

import lombok.SneakyThrows;

@Component
public class PlanDao {

	private final PlanRepository planRepository;
	
	@Autowired
	PlanDao(PlanRepository planRepository){
		this.planRepository=planRepository;
	}
	
	public Plan savePlan(Plan plan) {
		return planRepository.save(plan);
	}

	public Page<Plan> getAllPlans(Integer pageNo, Integer pageSize, String direction, String query) {
		Pageable pageable=PageRequest.of(pageNo, pageSize,direction.equals("ASC") || direction.equals("asc") ? Direction.ASC : Direction.DESC , query);
		return planRepository.findAll(pageable);
	}

	@SneakyThrows
	public Plan getPlanById(Integer planId) {
		return planRepository.findById(planId).get();
	}
}
