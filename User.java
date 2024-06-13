package com.example.demo.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Article")

	
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 20)
	 private int id;
	@Column(length = 20)
	    private String title;
	@Column(length = 20)
	    private String description;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(length = 20)
	    private Date publishDate;
	@Column(length = 20)
	    private String status;
	@Column(length = 20)
	    private String banner;
	private String email;
	
	    public User() {
	    	
	    }

		public User(int id, String title, String description, Date publishDate, String status, String banner,
				String email) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.publishDate = publishDate;
			this.status = status;
			this.banner = banner;
			this.email = email;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getPublishDate() {
			return publishDate;
		}

		public void setPublishDate(Date publishDate) {
			this.publishDate = publishDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getBanner() {
			return banner;
		}

		public void setBanner(String banner) {
			this.banner = banner;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", title=" + title + ", description=" + description + ", publishDate="
					+ publishDate + ", status=" + status + ", banner=" + banner + ", email=" + email + "]";
		}
		
	
}
