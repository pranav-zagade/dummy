package com.verinite.DummyInterestApp.controller;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;

import com.verinite.DummyInterestApp.BaseClassTest;
import com.verinite.dummyInterestApp.dto.PlanDto;

import io.restassured.RestAssured;

public class PlanControllerTest extends BaseClassTest {

	private String baseUrl;
	@LocalServerPort
	private String port;

	@Before
	public void setup() {
		super.setup();
		baseUrl = "http://localhost:" + port;
	}

	@Test
	public void createPlanTest() {
		createPlan();
	}

	@Test
	public void getAllPlansTest() {

	}

	private void createPlan() {
		PlanDto planDto = new PlanDto((float) 3.5, "Silver");
		RestAssured.given().baseUri(baseUrl + "/create/plans").header("Content-Type", "application/json").body(planDto)
				.post().then().statusCode(200).body("roi", is(planDto.getRoi()))
				.body("product", is(planDto.getProduct()));

	}
}
