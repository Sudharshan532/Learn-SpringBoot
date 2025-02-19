package com.in28minutes.learn_spring_framework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("Dependencies are wired.......");
	}

	/* After the dependencies are wired before any class accessing this class we can use PostContruct annotation to run the functionality */
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	/* Before the spring beans deleted from the context we can use @PreDestroy annotation to execute something */
	@PreDestroy
	public void cleanUp() {
		System.out.println("Closing all the connections.......");
	}
}

@Component
class SomeDependency{
	
	public void getReady() {
		System.out.println("Getting Ready for something..........");
	}
}

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.examples.f1")
public class PrePostAnnotationsContextLauncherApplication {
	

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class);){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}

	}

}
