package com.green.todolist1.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.info;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "식물관련 일정관리"
                , description = "plant management"
                , version = "v1"
        )
)
class SwaggerConfiguration {

}
