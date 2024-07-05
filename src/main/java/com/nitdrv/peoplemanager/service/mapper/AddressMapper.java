package com.nitdrv.peoplemanager.service.mapper;

import com.nitdrv.peoplemanager.domain.Address;
import com.nitdrv.peoplemanager.domain.Person;
import com.nitdrv.peoplemanager.service.dto.AddressDTO;
import com.nitdrv.peoplemanager.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "person", source = "person", qualifiedByName = "personFullName")
    AddressDTO toDto(Address s);

    @Named("personFullName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    PersonDTO toDtoPersonFullName(Person person);
}
