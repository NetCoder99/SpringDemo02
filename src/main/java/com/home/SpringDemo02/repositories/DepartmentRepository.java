package com.home.SpringDemo02.repositories;

import com.home.models.HumanResources.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {



}


