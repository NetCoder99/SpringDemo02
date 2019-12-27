package com.home.SpringDemo02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.models.HumanResources.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

    public List<Department> getDepartments() {
        return (List<Department>) repository.findAll();
    }	
	
}
