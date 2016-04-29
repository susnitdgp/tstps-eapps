package com.ntpc.neo4j.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.ntpc.neo4j.domain.Employee;

@Repository
public interface EmployeeRepository extends GraphRepository<Employee>{

}
