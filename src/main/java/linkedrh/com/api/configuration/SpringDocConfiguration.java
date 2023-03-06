package linkedrh.com.api.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI incidentConfigurationDoc() {
        return new OpenAPI()
                .info(new Info().title("linkedrh")
                        .description("api de de gestão de cursos para funcionários")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("linkedRh api, wiki e instruções de uso")
                        .url("https://github.com/lucasciannella/jdbc"));
    }
}
