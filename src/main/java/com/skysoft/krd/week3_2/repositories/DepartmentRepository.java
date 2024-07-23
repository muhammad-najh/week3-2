package com.skysoft.krd.week3_2.repositories;



import com.skysoft.krd.week3_2.entities.DepartmentEntity;
import com.skysoft.krd.week3_2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
