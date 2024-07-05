package com.nitdrv.peoplemanager.service;

import com.nitdrv.peoplemanager.domain.Person;
import com.nitdrv.peoplemanager.service.dto.PersonDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.nitdrv.peoplemanager.domain.Person}.
 */
public interface PersonService {
    /**
     * Save a person.
     *
     * @param personDTO the entity to save.
     * @return the persisted entity.
     */
    PersonDTO save(PersonDTO personDTO);

    /**
     * Updates a person.
     *
     * @param personDTO the entity to update.
     * @return the persisted entity.
     */
    PersonDTO update(PersonDTO personDTO);

    /**
     * Partially updates a person.
     *
     * @param personDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PersonDTO> partialUpdate(PersonDTO personDTO);

    /**
     * Get all the people.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PersonDTO> findAll(Pageable pageable);

    /**
     * Get the "id" person.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PersonDTO> findOne(Long id);

    /**
     * Get the "fullName" person ignoring case .
     *
     * @param fullName the fullName of the entity.
     * @return the entity.
     */
    List<PersonDTO> findByFullNameIgnoreCase(String fullName);

    /**
     * Delete the "id" person.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
