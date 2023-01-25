package com.condexo.model;

import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Nullable
	private String name;
	@Nullable
	private String surname;
	@Nullable
	private String address;
	private String zipCode;
	@Nullable
	@Enumerated(EnumType.STRING)
	private UserType userType;
	@Nullable
	private String email;
	private String phoneNumber;
	@Nullable
	private String fiscalCode;
	@Temporal(TemporalType.DATE)
	private LocalDate dateOfBirth;
	private Genre genre;
	@Nullable
	private String password;
	private Integer age;

}
