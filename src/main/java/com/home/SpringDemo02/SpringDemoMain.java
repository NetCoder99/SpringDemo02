package com.home.SpringDemo02;

import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.home.SpringDemo02.repositories.ContactTypeRepository;
import com.home.SpringDemo02.repositories.DepartmentRepository;
import com.home.models.HumanResources.ContactType;
import com.home.models.HumanResources.Department;

@SpringBootApplication
@EntityScan(basePackages = "com.home.models.HumanResources")
public class SpringDemoMain {

	private static final Logger log = LoggerFactory.getLogger(SpringDemoMain.class);
    
	@Autowired
	private DepartmentRepository deptRepository;
	@Autowired
	private ContactTypeRepository contactTypeRepository;
	
	public static void main(String[] args) {
		try {
			System.out.println("------ SpringDemoMain Started ------");
			SpringApplication.run(SpringDemoMain.class, args);
			System.out.println("------ SpringDemoMain Finished ------");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("------ SpringDemoMain Failed ------");
		}
	}
	
	@Bean
	@Order(3)
	public CommandLineRunner getDepartments(DepartmentRepository repository) {
		return (args) -> {
			log.info("--- getDepartments Started ---");
			for (Department department : repository.findAll()) {
				log.info(department.toString());
			}
			log.info("--- getDepartments Finished ---");
			log.info("");
		};
	}
	 
	
	@Component
	@Order(2)
	public class ApplicationRunnerBean implements ApplicationRunner {
	   @Override
	   public void run(ApplicationArguments arg0) throws Exception {
		   try {
			   System.out.println("------ SpringDemo02 Started ------");
			    
			   List<ContactType> tmpList = (List<ContactType>) contactTypeRepository.findAll();
			   tmpList.forEach(rec -> System.out.println(rec.toString()));
			   
			   System.out.println("------ SpringDemo02 Finsihed ------");
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
			   System.out.println("------ SpringDemo02 Failed ------");
		   }
		   
	   }
	}
	
	@Component
	@Order(1)
	public class ContactRunnerBean implements ApplicationRunner {
	   @Override
	   public void run(ApplicationArguments arg0) throws Exception {
		   try {
			   System.out.println("------ SpringDemo03 Started ------");
			    
			   List<ContactType> tmpList = (List<ContactType>) contactTypeRepository.findAll();
			   tmpList.forEach(rec -> System.out.println(rec.toString()));
			   
			   System.out.println("------ SpringDemo03 Finsihed ------");
		   }
		   catch(Exception ex)
		   {
			   ex.printStackTrace();
			   System.out.println("------ SpringDemo03 Failed ------");
		   }
		   
	   }
	}

}
