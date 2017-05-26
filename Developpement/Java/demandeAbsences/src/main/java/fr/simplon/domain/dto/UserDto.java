package fr.simplon.domain.dto;

import java.util.List;

public class UserDto {
	
	private String email;
	private String password;
	private int role;
	private EmployeDto employeDto;
	private List<AbsenceDto> absenceDto;
	
	public UserDto() {
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public EmployeDto getEmployeDto() {
		return employeDto;
	}

	public void setEmployeDto(EmployeDto employeDto) {
		this.employeDto = employeDto;
	}


	public List<AbsenceDto> getAbsenceDto() {
		return absenceDto;
	}


	public void setAbsenceDto(List<AbsenceDto> absenceDto) {
		this.absenceDto = absenceDto;
	}


	
}
