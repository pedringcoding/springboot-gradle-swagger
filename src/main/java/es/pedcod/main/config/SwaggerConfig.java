package es.pedcod.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Customizing Swagger by providing information about our API exposes for pet project
 */
@Configuration
@EnableSwagger2
@ComponentScan("es.pedcod.main")
public class SwaggerConfig {

	@Bean("api")
	@Description("Initializes the Docket with the new information about our API exposes for pet project")
	public Docket getApiBean() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
    }

	/**
	 * Add meta data for information about API services exposes. Pending replace constants with key language (i18N).
	 * 
	 * @return provider {@link ApiInfo#ApiInfo information} for APIs
	 */
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Pedring Coding")
                .description("Pet project for example using latest version to Spring-fox")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

}
