package com.home.SpringDemo02.repositories;

import com.home.models.HumanResources.ContactType;
import org.springframework.data.repository.CrudRepository;

public interface ContactTypeRepository extends CrudRepository<ContactType, Integer> {



}
