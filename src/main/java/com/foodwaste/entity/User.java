package com.foodwaste.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	 @Column(unique = true)
	    private String email;

	 private String password;

	    @Enumerated(EnumType.STRING)
	    private Role role;

	    private String phone;

	    private String address;

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public Role getRole() {
			return role;
		}

		public String getPhone() {
			return phone;
		}

		public String getAddress() {
			return address;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		

}