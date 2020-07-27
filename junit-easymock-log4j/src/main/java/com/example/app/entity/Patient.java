package com.example.app.entity;

public class Patient {
	private Integer patientId;
	private String patientName;
	private Long  contactNumber;
	private String emailAddress;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", contactNumber=" + contactNumber
				+ ", emailAddress=" + emailAddress + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
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
		Patient other = (Patient) obj;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		return true;
	}
	public Patient(Integer patientId, String patientName, Long contactNumber, String emailAddress) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
