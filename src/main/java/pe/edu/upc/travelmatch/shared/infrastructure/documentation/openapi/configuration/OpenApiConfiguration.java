package pe.edu.upc.travelmatch.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI travelMatchOpenApi() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(externalDocs());
    }

    private Info apiInfo() {
        return new Info()
                .title("TravelMatch API")
                .description("REST API documentation for TravelMatch, a personalized tourism platform.")
                .version("v1.0.0")
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact()
                        .name("TravelMatch Team")
                        .url("https://github.com/G2-Aplicaciones-Open-Source")
                        .email("contacto@travelmatch.pe"));
    }

    private ExternalDocumentation externalDocs() {
        return new ExternalDocumentation()
                .description("TravelMatch External Documentation")
                .url("https://github.com/G2-Aplicaciones-Open-Source/docs");
    }
}
