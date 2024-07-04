package com.nitdrv.peoplemanager;

import com.nitdrv.peoplemanager.config.AsyncSyncConfiguration;
import com.nitdrv.peoplemanager.config.EmbeddedSQL;
import com.nitdrv.peoplemanager.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { PeopleManagerApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedSQL
public @interface IntegrationTest {
}
