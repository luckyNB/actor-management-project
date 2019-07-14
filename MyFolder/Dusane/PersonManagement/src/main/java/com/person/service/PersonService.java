package com.person.service;

import com.person.dto.PersonDTO;
import com.person.response.Response;

public interface PersonService {

	Response register(PersonDTO dto);

}
