package com.nitdrv.peoplemanager.repository;

import com.nitdrv.peoplemanager.domain.Email;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Email entity.
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    default Optional<Email> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Email> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Email> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(value = "select email from Email email left join fetch email.person", countQuery = "select count(email) from Email email")
    Page<Email> findAllWithToOneRelationships(Pageable pageable);

    @Query("select email from Email email left join fetch email.person")
    List<Email> findAllWithToOneRelationships();

    @Query("select email from Email email left join fetch email.person where email.id =:id")
    Optional<Email> findOneWithToOneRelationships(@Param("id") Long id);
}
