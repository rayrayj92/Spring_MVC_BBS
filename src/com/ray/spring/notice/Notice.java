package com.ray.spring.notice;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String title;
	private String content;
	private String author;
	private Date date;
	private int view;
	private String file_name;
	private String file_path;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(String title, String content, String author, Date date, int view, String file_name,
			String file_path) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.view = view;
		this.file_name = file_name;
		this.file_path = file_path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	

}
