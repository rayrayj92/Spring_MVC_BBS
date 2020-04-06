package com.ray.spring.notice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends CrudRepository<Notice, Integer>{

	@Query(value = "select n from Notice n where n.title LIKE '%' || :keyword || '%'")
	public List<Notice> searchByTitle(@Param("keyword") String keyword);
	
	@Query(value = "select n from Notice n where n.author LIKE '%' || :keyword || '%'")
	public List<Notice> searchByAuthor(@Param("keyword") String keyword);
	
}
