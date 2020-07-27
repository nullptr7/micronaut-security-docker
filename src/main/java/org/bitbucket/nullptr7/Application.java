package org.bitbucket.nullptr7;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut Docker Security Demo",
                version = "1.0",
                description = "Security version implemented in Micronaut Swagger",
                license = @License(name = "Apache 2.0", url = "https://www.bitbucket.org/ishan-shah"),
                contact = @Contact(url = "https://www.bitbucket.org/ishan-shah", name = "Ishan Shah", email = "ishannshah@gmail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
