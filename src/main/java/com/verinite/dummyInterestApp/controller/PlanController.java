package com.verinite.dummyInterestApp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.dummyInterestApp.dao.PlanDao;
import com.verinite.dummyInterestApp.dto.PlanDto;
import com.verinite.dummyInterestApp.model.Plan;

@RestController
public class PlanController {

	private final PlanDao planDao;
	private ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	public PlanController(PlanDao planDao) {
		this.planDao=planDao;
	}
	
	@PostMapping("/create/plans")
	public ResponseEntity<Plan> savePlan(@RequestBody PlanDto planDto)
	{
		Plan plan=planDao.savePlan(modelMapper.map(planDto,Plan.class));
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@GetMapping("/get/plans")
	public ResponseEntity<Page<Plan>> getAllPlans(
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "query", required = false) String query
			)
	{
		Page<Plan> plan= planDao.getAllPlans(pageNo,pageSize,direction,query);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@GetMapping("/get/plans/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable(value="planId") Integer planId){
		return new ResponseEntity<>(planDao.getPlanById(planId),HttpStatus.OK);
	}
}
