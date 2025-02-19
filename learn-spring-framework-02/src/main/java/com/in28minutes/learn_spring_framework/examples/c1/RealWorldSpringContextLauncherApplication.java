package com.in28minutes.learn_spring_framework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.examples.c1")
public class RealWorldSpringContextLauncherApplication {
	
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class);){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println("\n------ End of Bean Definitions ------ \n");
			System.out.println("Max element in the Database: "+context.getBean(BusinessClassService.class).findmax());
			
		}

	}

}
