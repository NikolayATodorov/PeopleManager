package com.nitdrv.peoplemanager.service;

import com.nitdrv.peoplemanager.service.dto.EmailDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.nitdrv.peoplemanager.domain.Email}.
 */
public interface EmailService {
    /**
     * Save a email.
     *
     * @param emailDTO the entity to save.
     * @return the persisted entity.
     */
    EmailDTO save(EmailDTO emailDTO);

    /**
     * Updates a email.
     *
     * @param emailDTO the entity to update.
     * @return the persisted entity.
     */
    EmailDTO update(EmailDTO emailDTO);

    /**
     * Partially updates a email.
     *
     * @param emailDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<EmailDTO> partialUpdate(EmailDTO emailDTO);

    /**
     * Get all the emails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EmailDTO> findAll(Pageable pageable);

    /**
     * Get all the emails with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EmailDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" email.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmailDTO> findOne(Long id);

    /**
     * Delete the "id" email.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
