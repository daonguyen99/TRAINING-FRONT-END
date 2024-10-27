package com.app.mvc.dbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.mvc.dbz.entities.Tutorial;
@Repository
public interface ToturialRepository extends JpaRepository<Tutorial, Integer> {
	@Query( name = "select * from tutorial where title LIKE CONCAT('%', ?, '%')", nativeQuery = true)
	List<Tutorial> findByTitle(String searchKey);
	
}
