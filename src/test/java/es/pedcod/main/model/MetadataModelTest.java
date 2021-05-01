package es.pedcod.main.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Unit Test Class for data structure interface {@link MetadataModel#MetadataModel model}.
 */
@DisplayName("A Metadata Model")
@TestMethodOrder(Alphanumeric.class)
class MetadataModelTest {

	@Nested
	@DisplayName("For Construct")
	class testConstruct {

		@Test
		@DisplayName("When no arguments should return empty instance")
		void testNoArgsConstructor() {
			final MetadataModel expectModel = MetadataModel.builder().build();

			final MetadataModel actualModel = new MetadataModel();

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When all arguments should return populated instance")
		void testAllArgsConstructor() {
			final MetadataModel expectModel = MetadataModel.builder()
					.principal(UUID.randomUUID())
					.created(Long.MIN_VALUE)
					.build();

			final MetadataModel actualModel = new MetadataModel(
					expectModel.getPrincipal(), 
					expectModel.getCreated());

			thenSameModel(actualModel, expectModel);
		}
	}

	@Nested
	@DisplayName("For Principal field")
	class testFieldPrincipal {

		@Test
		@DisplayName("When set null value")
		void testSetNullvalue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.principal(null)
					.build();

			MetadataModel actualModel = new MetadataModel();
			actualModel.setPrincipal(expectModel.getPrincipal());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When set some valid value")
		void testSetSomeValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.principal(UUID.randomUUID())
					.build();

			MetadataModel actualModel = new MetadataModel();
			actualModel.setPrincipal(expectModel.getPrincipal());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When build with null value")
		void testBuildNullValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.principal(null)
					.build();

			final MetadataModel actualModel = MetadataModel.builder()
					.principal(expectModel.getPrincipal())
					.build();

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When build with some valid value")
		void testBuildSomeValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.principal(UUID.randomUUID())
					.build();

			final MetadataModel actualModel = MetadataModel.builder()
					.principal(expectModel.getPrincipal())
					.build();

			thenSameModel(actualModel, expectModel);
		}
	}

	@Nested
	@DisplayName("For Created field")
	class testFieldCreated {

		@Test
		@DisplayName("When set null value")
		void testSetNullvalue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.created(null)
					.build();

			MetadataModel actualModel = new MetadataModel();
			actualModel.setPrincipal(expectModel.getPrincipal());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When set some valid value")
		void testSetSomeValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.created(Long.MIN_VALUE)
					.build();

			MetadataModel actualModel = new MetadataModel();
			actualModel.setCreated(expectModel.getCreated());

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When build with null value")
		void testBuildNullValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.created(null)
					.build();

			final MetadataModel actualModel = MetadataModel.builder()
					.created(expectModel.getCreated())
					.build();

			thenSameModel(actualModel, expectModel);
		}

		@Test
		@DisplayName("When build with some valid value")
		void testBuildSomeValue() {
			final MetadataModel expectModel = MetadataModel.builder()
					.created(Long.MIN_VALUE)
					.build();

			final MetadataModel actualModel = MetadataModel.builder()
					.created(expectModel.getCreated())
					.build();

			thenSameModel(actualModel, expectModel);
		}
	}

	/**
	 * Check the given assertion at model for corner/nominal case
	 * 
	 * @param actual The element to check
	 * @param expect The Reference value to check
	 */
	private static void thenSameModel(final MetadataModel actual, final MetadataModel expect) {
		assertThat(actual).satisfies(pojo -> {
			assertThat(pojo.getPrincipal()).isEqualTo(expect.getPrincipal());
			assertThat(pojo.getCreated()).isEqualTo(expect.getCreated());
		});
	}
}
