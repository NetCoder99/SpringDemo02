package com.home.SpringDemo02;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.home.models.HumanResources.Department;

@SpringBootApplication
@EntityScan(basePackages = "com.home.models.HumanResources")
public class SpringDemoMain {

	private static final Logger log = LoggerFactory.getLogger(SpringDemoMain.class);
    
	@Autowired
    private static DepartmentService departmentService;
    
	public static void main(String[] args) {
		try {
			System.out.println("------ SpringDemoMain Started ------");
			
			DepartmentService t2 = new DepartmentService();
			List<Department> tmp = t2.getDepartments();
			//List<Department> tmp = departmentService.getDepartments();
			SpringApplication.run(SpringDemoMain.class, args);
			System.out.println("------ SpringDemoMain Finished ------");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("------ SpringDemoMain Failed ------");
		}
	}
	
	@Bean
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
	 
//	@Component
//	public class ApplicationRunnerBean implements ApplicationRunner {
//	   @Override
//	   public void run(ApplicationArguments arg0) throws Exception {
//		   try {
//			   System.out.println("------ SpringDemo02 Started ------");
//			   
//			   List<Department> tmpList = null;
//			   //throw new Exception("Test of exception process.");
//			   
//			   System.out.println("------ SpringDemo02 Finsihed ------");
//		   }
//		   catch(Exception ex)
//		   {
//			   ex.printStackTrace();
//			   System.out.println("------ SpringDemo02 Failed ------");
//		   }
//		   
//	   }
//	}
}
