package com.student.service;

import com.student.dto.StudentDTO;
import com.student.response.Response;

public interface StudentService {

	Response register(StudentDTO dto);

}
