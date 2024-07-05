package com.nitdrv.peoplemanager.service.mapper;

import com.nitdrv.peoplemanager.domain.Person;
import com.nitdrv.peoplemanager.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {}
