package com.mostafa.repo;

import com.mostafa.entity.EmpType;
import com.mostafa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpTypeRepo extends JpaRepository<EmpType, Long> {
    EmpType findByTypeCode(String empTypeCode);
}
