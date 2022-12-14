package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
* 
* Model class for Storing Business Details
* 
*/
 
@Entity
@Table(name = "Business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Category")
	private String businessCategory;

	@NotBlank
	@Size(max = 40)
	@Column(name = "Business_Type")
	private String businessType;

	@NotNull
	@Column(name = "Business_Turnover")
	private Long businessTurnover;

	@NotNull
	@Column(name = "Capital_Invested ")
	private Long capitalInvested;

	@NotNull
	@Column(name = "Total_Employees")
	private Long totalEmployees;

	@NotNull
	@Column(name = "Business_Value")
	private Long businessValue;

	@NotNull
	@Column(name = "Business_Age")
	private Long businessAge;

}
