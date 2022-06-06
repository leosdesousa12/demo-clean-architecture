package com.br.user.registration.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.PathProvider
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.paths.RelativePathProvider
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.servlet.ServletContext

@Configuration
@EnableSwagger2
class SaggerConfig(val servletContext: ServletContext) {


    @Value("\${server.servlet.context-path}")
    private val swagger_base_path: String? = null

    @Value("\${swagger.title.api}")
    private val title: String? = null

    @Value("\${swagger.api.description}")
    private val description: String? = null

    @Value("\${swagger.api.version}")
    private val version: String? = null

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .pathProvider(getPath())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.br.user.registration.demo"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.apiInfo());
    }

    private fun getPath(): PathProvider {
        class Path(servletContext: ServletContext) : RelativePathProvider(servletContext) {
            override fun getApplicationBasePath(): String = swagger_base_path.orEmpty()
        }
        return Path(servletContext)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            title,
            description,
            version,
            null,
            null,
            null,
            null,
            emptyList()
        )
    }

}



