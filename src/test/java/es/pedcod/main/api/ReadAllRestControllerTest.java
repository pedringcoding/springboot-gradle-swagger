package es.pedcod.main.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.pedcod.main.model.MetadataModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import nl.altindag.log.LogCaptor;

/**
 * Unit Test Class for {@link org.springframework.web.bind.annotation.RestController}
 */
@DisplayName("API to read all metadata")
@TestMethodOrder(Alphanumeric.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
class ReadAllRestControllerTest {

	/**
	 * The principal component to test
	 */
	ReadAllRestController component;

	/**
	 * The handler traces engine
	 */
	LogCaptor logCaptor;

	@Nested
	@DisplayName("For Read all")
	class testReadAll {

		/*
		 * should be executed before each test method
		 */
		@BeforeEach
		public void setUpMethod() {
			// Set trace engine configuration
			setLogCaptor(LogCaptor.forClass(ReadAllRestController.class));
			getLogCaptor().setLogLevelToDebug();

			setComponent(new ReadAllRestController());
		}

		/*
		 * should be executed after each test method
		 */
		@AfterEach
		public void setDownMethod() {
			getLogCaptor().clearLogs();
			setComponent(null);
		}

		@Test
		@DisplayName("By default, should return populate list with only two items")
		void testExistsElements() {
			final List<MetadataModel> actualModel = getComponent().readAll();

			assertThat(actualModel).hasSize(2);
		}

		@Test
		@DisplayName("When exists elements should these must be trace in debug level")
		void testTraceElementsDebugLevel() {
			getComponent().readAll();

			assertThat(getLogCaptor().getDebugLogs())
				.hasSize(3)
				.satisfies(msgs -> {
					assertThat(msgs.stream().findFirst().get())
						.contains("Try to get all elements type by metadata in the system");
				});
		}

	}

}
