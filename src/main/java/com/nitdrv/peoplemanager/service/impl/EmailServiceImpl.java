package com.nitdrv.peoplemanager.service.impl;

import com.nitdrv.peoplemanager.domain.Email;
import com.nitdrv.peoplemanager.repository.EmailRepository;
import com.nitdrv.peoplemanager.service.EmailService;
import com.nitdrv.peoplemanager.service.dto.EmailDTO;
import com.nitdrv.peoplemanager.service.mapper.EmailMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.nitdrv.peoplemanager.domain.Email}.
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    private final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final EmailRepository emailRepository;

    private final EmailMapper emailMapper;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    @Override
    public EmailDTO save(EmailDTO emailDTO) {
        log.debug("Request to save Email : {}", emailDTO);
        Email email = emailMapper.toEntity(emailDTO);
        email = emailRepository.save(email);
        return emailMapper.toDto(email);
    }

    @Override
    public EmailDTO update(EmailDTO emailDTO) {
        log.debug("Request to update Email : {}", emailDTO);
        Email email = emailMapper.toEntity(emailDTO);
        email = emailRepository.save(email);
        return emailMapper.toDto(email);
    }

    @Override
    public Optional<EmailDTO> partialUpdate(EmailDTO emailDTO) {
        log.debug("Request to partially update Email : {}", emailDTO);

        return emailRepository
            .findById(emailDTO.getId())
            .map(existingEmail -> {
                emailMapper.partialUpdate(existingEmail, emailDTO);

                return existingEmail;
            })
            .map(emailRepository::save)
            .map(emailMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Emails");
        return emailRepository.findAll(pageable).map(emailMapper::toDto);
    }

    public Page<EmailDTO> findAllWithEagerRelationships(Pageable pageable) {
        return emailRepository.findAllWithEagerRelationships(pageable).map(emailMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmailDTO> findOne(Long id) {
        log.debug("Request to get Email : {}", id);
        return emailRepository.findOneWithEagerRelationships(id).map(emailMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Email : {}", id);
        emailRepository.deleteById(id);
    }
}
