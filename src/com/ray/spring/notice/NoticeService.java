package com.ray.spring.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	NoticeRepository repo;
	
	public NoticeService() {
		// TODO Auto-generated constructor stub
	}
	
	public void create(Notice notice) {
		repo.save(notice);
	}
	
	public List<Notice> listAll(){
		return (List<Notice>) repo.findAll();
	}
	
	public List<Notice> getById(List<Integer> ids){
		return (List<Notice>) repo.findAllById(ids);
	}
	
	public Notice get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteAll(List<Notice> notice) {
		repo.deleteAll(notice);
	}
	
	public List<Notice> searchByTitle(String keyword){
		return repo.searchByTitle(keyword);
	}
	
	public List<Notice> searchByAuthor(String keyword){
		return repo.searchByAuthor(keyword);
	}
}
