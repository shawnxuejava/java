package com.fdmgroup.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="C_USER")
@NamedQueries({ @NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "user.findById", query = "SELECT u FROM User u WHERE u.id= :uid "),
	@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u WHERE u.username= :uname"),
	@NamedQuery(name = "user.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname= :ufirstname"),
	@NamedQuery(name = "user.findByLastname", query = "SELECT u FROM User u WHERE u.lastname= :ulastname "),
	@NamedQuery(name = "user.findLikeFirstname", query = "SELECT u FROM User u WHERE u.firstname LIKE :ufirstname") })
public class User implements IStorable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(name="pw",nullable=false)
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String avatar;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Calendar joinDate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Role role;

	public User() {
		super();
	}

	public User(String username, String firstname, String lastname, String email, String avatar, UserStatus userStatus,
			Calendar joinDate, Role role) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.avatar = avatar;
		this.userStatus = userStatus;
		this.joinDate = joinDate;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Calendar getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", userStatus=" + userStatus + ", joinDate=" + joinDate + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
	
}
