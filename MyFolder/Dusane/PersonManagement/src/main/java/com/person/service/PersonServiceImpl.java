package com.person.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.dto.PersonDTO;
import com.person.model.Person;
import com.person.repository.PersonRepository;
import com.person.response.Response;
import com.person.response.ResponseHelper;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	PersonRepository repository;

	@Override
	public Response register(PersonDTO dto) {
		Person person = mapper.map(dto, Person.class);
repository.save(person);

Response response=ResponseHelper.statusInfo(200, "Successfully registration");

return response ;
	}

}
