package com.akshay.spring.dtos;

public class StudentDTO {

	Long id;
	String rollNumber;
	String firstName;
	String lastName;
	String standard;
	String phoneNumber;
	String emailId;
	String fathersName;
	String mothersName;
	String address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", standard=" + standard + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", fathersName=" + fathersName + ", mothersName=" + mothersName + ", address=" + address + "]";
	}
	
	

}
