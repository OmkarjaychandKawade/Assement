package com.example.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class author {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(length = 20)
	    private int id;
	    @Column(length = 20)
//	    @ManyToMany
	    private String name;
	    
	    public author() {
	    	
	    }

		public author(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "author [id=" + id + ", name=" + name + "]";
		}
	    
	}


