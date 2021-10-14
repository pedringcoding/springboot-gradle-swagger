package es.pedcod.main.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Unit Test Class for configuration class
 */
@DisplayName("Configuration to OpenAPI")
@TestMethodOrder(Alphanumeric.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
class SwaggerConfigTest {

    /**
     * The principal component to test
     */
    SwaggerConfig configuration;

    @Nested
    @DisplayName("Docket Bean")
    class testDocket {
        /*
         * should be executed before each test method
         */
        @BeforeEach
        public void setUpMethod() {
            setConfiguration(new SwaggerConfig());
        }

        /*
         * should be executed after each test method
         */
        @AfterEach
        public void setDownMethod() {
            setConfiguration(null);
        }

        @Test
        @DisplayName("Default instance must not be null")
        void testExistsElements() {
            final Docket actualBean = getConfiguration().getApiBean();

            assertThat(actualBean).isNotNull();
        }
    }
}
