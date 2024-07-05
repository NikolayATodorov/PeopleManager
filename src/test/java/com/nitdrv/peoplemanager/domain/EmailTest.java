package com.nitdrv.peoplemanager.domain;

import static com.nitdrv.peoplemanager.domain.EmailTestSamples.*;
import static com.nitdrv.peoplemanager.domain.PersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.nitdrv.peoplemanager.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Email.class);
        Email email1 = getEmailSample1();
        Email email2 = new Email();
        assertThat(email1).isNotEqualTo(email2);

        email2.setId(email1.getId());
        assertThat(email1).isEqualTo(email2);

        email2 = getEmailSample2();
        assertThat(email1).isNotEqualTo(email2);
    }

    @Test
    void personTest() {
        Email email = getEmailRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        email.setPerson(personBack);
        assertThat(email.getPerson()).isEqualTo(personBack);

        email.person(null);
        assertThat(email.getPerson()).isNull();
    }
}
