package com.krutrim.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "enrollments")
public class Enrollment {

	@Id
	private String id;

	private String courseName;
	@NotBlank(message = "name can not be blank")
	private String name;
	private String email;
	private String phone;
	private String profession;
	private String mode;
	@CreatedDate
	private LocalDateTime createdDate;

}
