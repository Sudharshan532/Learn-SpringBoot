package com.in28minutes.learn_spring_framework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessClassService {

	private DataService dataService;
	
	public BusinessClassService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findmax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
	
}
