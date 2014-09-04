package com.fursel.store.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fursel.util.validator.FieldMatch;
import com.fursel.util.validator.FieldMatchList;

@FieldMatchList({
    @FieldMatch(first = "password", second = "cpassword", message = "The password fields must match"),
})
public class Customer {
	
	private String id;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@NotEmpty
	private String cpassword;
	
	private boolean active;

	public Customer() {

	}

	public Customer(String id, String email, String password, String cpassword,
			boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	public com.fursel.persistence.Customer toEntity(){
		com.fursel.persistence.Customer customer = new com.fursel.persistence.Customer();
		customer.setActive(true);
		customer.setEmail(this.getEmail());
		customer.setPassword(this.getPassword());
		return customer;
	}
}
