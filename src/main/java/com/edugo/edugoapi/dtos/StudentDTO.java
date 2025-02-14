package com.edugo.edugoapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private Long id;
	private String name;
	private String cpf;
	private String gender;
	private String email;
	private String phone;
	private String profession;
}
