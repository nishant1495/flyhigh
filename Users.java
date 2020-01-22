package com.app.pojos;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="users")
public class Users 
{
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String phoneno;
	private Role role=Role.PASSENGER;
	private Byte status=0;
	
	public Users() {
	System.out.println("Inside users pojo");
	}
	public Users(String name, String email, String password, String phoneno, Role role, Byte status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.role = role;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(unique=true,nullable=false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(unique=true,nullable=false)
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	
	
}
