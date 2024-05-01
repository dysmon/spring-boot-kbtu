package com.kbtu.database.repository;

import com.kbtu.database.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

    public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}
