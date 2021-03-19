package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class School {

	@Id
	@Column
	@GeneratedValue
	private int schoolid;
	@Column
	private String schoolName;
	@Column
	private int standard;
	@Column
	private String section;
	
	@OneToMany(mappedBy = "school")
	List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public School() {
		
	}

	public School(int schoolid, String schoolName, int standard, String section) {
		super();
		this.schoolid = schoolid;
		this.schoolName = schoolName;
		this.standard = standard;
		this.section = section;
	}

	public int getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "School [schoolid=" + schoolid + ", schoolName=" + schoolName + ", standard=" + standard + ", section="
				+ section + "]";
	}

	
}
