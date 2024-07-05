package com.nitdrv.peoplemanager.domain;

import static com.nitdrv.peoplemanager.domain.AddressTestSamples.*;
import static com.nitdrv.peoplemanager.domain.EmailTestSamples.*;
import static com.nitdrv.peoplemanager.domain.PersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.nitdrv.peoplemanager.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Person.class);
        Person person1 = getPersonSample1();
        Person person2 = new Person();
        assertThat(person1).isNotEqualTo(person2);

        person2.setId(person1.getId());
        assertThat(person1).isEqualTo(person2);

        person2 = getPersonSample2();
        assertThat(person1).isNotEqualTo(person2);
    }

    @Test
    void emailsTest() {
        Person person = getPersonRandomSampleGenerator();
        Email emailBack = getEmailRandomSampleGenerator();

        person.addEmails(emailBack);
        assertThat(person.getEmails()).containsOnly(emailBack);
        assertThat(emailBack.getPerson()).isEqualTo(person);

        person.removeEmails(emailBack);
        assertThat(person.getEmails()).doesNotContain(emailBack);
        assertThat(emailBack.getPerson()).isNull();

        person.emails(new HashSet<>(Set.of(emailBack)));
        assertThat(person.getEmails()).containsOnly(emailBack);
        assertThat(emailBack.getPerson()).isEqualTo(person);

        person.setEmails(new HashSet<>());
        assertThat(person.getEmails()).doesNotContain(emailBack);
        assertThat(emailBack.getPerson()).isNull();
    }

    @Test
    void addressesTest() {
        Person person = getPersonRandomSampleGenerator();
        Address addressBack = getAddressRandomSampleGenerator();

        person.addAddresses(addressBack);
        assertThat(person.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getPerson()).isEqualTo(person);

        person.removeAddresses(addressBack);
        assertThat(person.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getPerson()).isNull();

        person.addresses(new HashSet<>(Set.of(addressBack)));
        assertThat(person.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getPerson()).isEqualTo(person);

        person.setAddresses(new HashSet<>());
        assertThat(person.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getPerson()).isNull();
    }
}
