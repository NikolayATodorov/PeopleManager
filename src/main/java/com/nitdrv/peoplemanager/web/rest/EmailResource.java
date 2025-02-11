package com.nitdrv.peoplemanager.web.rest;

import com.nitdrv.peoplemanager.repository.EmailRepository;
import com.nitdrv.peoplemanager.service.EmailService;
import com.nitdrv.peoplemanager.service.dto.EmailDTO;
import com.nitdrv.peoplemanager.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.nitdrv.peoplemanager.domain.Email}.
 */
@RestController
@RequestMapping("/api/emails")
public class EmailResource {

    private final Logger log = LoggerFactory.getLogger(EmailResource.class);

    private static final String ENTITY_NAME = "email";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EmailService emailService;

    private final EmailRepository emailRepository;

    public EmailResource(EmailService emailService, EmailRepository emailRepository) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
    }

    /**
     * {@code POST  /emails} : Create a new email.
     *
     * @param emailDTO the emailDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new emailDTO, or with status {@code 400 (Bad Request)} if the email has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<EmailDTO> createEmail(@Valid @RequestBody EmailDTO emailDTO) throws URISyntaxException {
        log.debug("REST request to save Email : {}", emailDTO);
        if (emailDTO.getId() != null) {
            throw new BadRequestAlertException("A new email cannot already have an ID", ENTITY_NAME, "idexists");
        }
        emailDTO = emailService.save(emailDTO);
        return ResponseEntity.created(new URI("/api/emails/" + emailDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, emailDTO.getId().toString()))
            .body(emailDTO);
    }

    /**
     * {@code PUT  /emails/:id} : Updates an existing email.
     *
     * @param id the id of the emailDTO to save.
     * @param emailDTO the emailDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated emailDTO,
     * or with status {@code 400 (Bad Request)} if the emailDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the emailDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmailDTO> updateEmail(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody EmailDTO emailDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Email : {}, {}", id, emailDTO);
        if (emailDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, emailDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!emailRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        emailDTO = emailService.update(emailDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, emailDTO.getId().toString()))
            .body(emailDTO);
    }

    /**
     * {@code PATCH  /emails/:id} : Partial updates given fields of an existing email, field will ignore if it is null
     *
     * @param id the id of the emailDTO to save.
     * @param emailDTO the emailDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated emailDTO,
     * or with status {@code 400 (Bad Request)} if the emailDTO is not valid,
     * or with status {@code 404 (Not Found)} if the emailDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the emailDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<EmailDTO> partialUpdateEmail(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody EmailDTO emailDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Email partially : {}, {}", id, emailDTO);
        if (emailDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, emailDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!emailRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EmailDTO> result = emailService.partialUpdate(emailDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, emailDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /emails} : get all the emails.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of emails in body.
     */
    @GetMapping("")
    public ResponseEntity<List<EmailDTO>> getAllEmails(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        @RequestParam(name = "eagerload", required = false, defaultValue = "true") boolean eagerload
    ) {
        log.debug("REST request to get a page of Emails");
        Page<EmailDTO> page;
        if (eagerload) {
            page = emailService.findAllWithEagerRelationships(pageable);
        } else {
            page = emailService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /emails/:id} : get the "id" email.
     *
     * @param id the id of the emailDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the emailDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmailDTO> getEmail(@PathVariable("id") Long id) {
        log.debug("REST request to get Email : {}", id);
        Optional<EmailDTO> emailDTO = emailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(emailDTO);
    }

    /**
     * {@code DELETE  /emails/:id} : delete the "id" email.
     *
     * @param id the id of the emailDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable("id") Long id) {
        log.debug("REST request to delete Email : {}", id);
        emailService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
