package com.student.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDTO;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.response.Response;
import com.student.response.ResponseHelper;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	StudentRepository repository;

	@Override
	public Response register(StudentDTO dto) {

		Student student = mapper.map(dto, Student.class);
		repository.save(student);

		Response response = ResponseHelper.statusInfo(200, "Successfully registered");
		// TODO Auto-generated method stub
		return response;
	}

}
