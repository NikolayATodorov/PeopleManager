package com.nitdrv.peoplemanager.service.mapper;

import com.nitdrv.peoplemanager.domain.Email;
import com.nitdrv.peoplemanager.domain.Person;
import com.nitdrv.peoplemanager.service.dto.EmailDTO;
import com.nitdrv.peoplemanager.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Email} and its DTO {@link EmailDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmailMapper extends EntityMapper<EmailDTO, Email> {
    @Mapping(target = "person", source = "person", qualifiedByName = "personFullName")
    EmailDTO toDto(Email s);

    @Named("personFullName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    PersonDTO toDtoPersonFullName(Person person);
}
