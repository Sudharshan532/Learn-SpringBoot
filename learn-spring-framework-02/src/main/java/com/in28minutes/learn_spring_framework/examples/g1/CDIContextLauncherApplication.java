package com.in28minutes.learn_spring_framework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;

	public DataService getDataService() {
		System.out.println("Data Service Getter");
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Data Service Setter");
		this.dataService = dataService;
	}
	
}

@Component
class DataService{

}


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.examples.g1")
public class CDIContextLauncherApplication {
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}

	}

}
