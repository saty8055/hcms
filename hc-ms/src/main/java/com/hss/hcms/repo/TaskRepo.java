package com.hss.hcms.repo;

import com.hss.hcms.entity.Employee;
import com.hss.hcms.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, String> {

	
}
