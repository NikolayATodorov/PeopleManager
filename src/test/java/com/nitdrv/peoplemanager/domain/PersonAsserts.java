package com.nitdrv.peoplemanager.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPersonAllPropertiesEquals(Person expected, Person actual) {
        assertPersonAutoGeneratedPropertiesEquals(expected, actual);
        assertPersonAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPersonAllUpdatablePropertiesEquals(Person expected, Person actual) {
        assertPersonUpdatableFieldsEquals(expected, actual);
        assertPersonUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPersonAutoGeneratedPropertiesEquals(Person expected, Person actual) {
        assertThat(expected)
            .as("Verify Person auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPersonUpdatableFieldsEquals(Person expected, Person actual) {
        assertThat(expected)
            .as("Verify Person relevant properties")
            .satisfies(e -> assertThat(e.getFullName()).as("check fullName").isEqualTo(actual.getFullName()))
            .satisfies(e -> assertThat(e.getPin()).as("check pin").isEqualTo(actual.getPin()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPersonUpdatableRelationshipsEquals(Person expected, Person actual) {}
}
