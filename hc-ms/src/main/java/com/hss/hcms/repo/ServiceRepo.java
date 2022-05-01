package com.hss.hcms.repo;

import com.hss.hcms.entity.Services;
import com.hss.hcms.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Services, String> {

	
}
