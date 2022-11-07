package com.cognizant.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
* 
* Model class for Storing Consumer Details
* 
*/

@Entity
@Table(name="Consumer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "First_Name")
	private String firstName;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "DOB")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone="IST")
	private Date dob;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Business_Name")
	private String businessName;
	
	@NotBlank
	@Size(max = 12)
	@Column(name = "PAN_Details")
	private String panDetails;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Email")
	private String email;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "Phone")
	private String phone;
	
	@NotBlank
	@Size(max = 40)
	@Column(name = "Website")
	private String website;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "Business_Overview")
	private String businessOverview;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Validity_of_Consumer")
	private String validity;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "Agent_Name")
	private String agentName;
	
	@NotNull
	@Column(name = "Agent_ID")
	private Long agentID;


	@JoinColumn(name = "Business")
	@OneToOne
	private Business business;

	@JoinTable(name = "Property_table")
	@ManyToMany
	private List<Property> property;


	
	

}
