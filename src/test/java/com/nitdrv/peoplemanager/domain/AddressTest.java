package com.nitdrv.peoplemanager.domain;

import static com.nitdrv.peoplemanager.domain.AddressTestSamples.*;
import static com.nitdrv.peoplemanager.domain.PersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.nitdrv.peoplemanager.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Address.class);
        Address address1 = getAddressSample1();
        Address address2 = new Address();
        assertThat(address1).isNotEqualTo(address2);

        address2.setId(address1.getId());
        assertThat(address1).isEqualTo(address2);

        address2 = getAddressSample2();
        assertThat(address1).isNotEqualTo(address2);
    }

    @Test
    void personTest() {
        Address address = getAddressRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        address.setPerson(personBack);
        assertThat(address.getPerson()).isEqualTo(personBack);

        address.person(null);
        assertThat(address.getPerson()).isNull();
    }
}
