package com.sebbia.testtask;

import com.google.common.base.Predicates;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket apiDescription() {
        ApiInfo info = new ApiInfo(
                "Тестовое задание",
                "Данный сервис представляет собой мини-сервис новостей.<br/>" +
                        "<br/>" +
                        "Есть список категорий новостей.<br/>" +
                        "В каждой категории есть список новостей, отдаваемых в коротком виде.<br/>" +
                        "Каждую новостью можно запросить в полном виде, чтобы получить html содержимое.<br/>" +
                        "<br/>" +
                        "В зависимости от платформы, задача заключается в следующем:<br/>" +
                        "<br/>" +
                        "Backend:<br/>" +
                        "Нужно в точности повторить описанное ниже API.<br/>" +
                        "<br/>" +
                        "Frontend (javascript), iOS, Android:<br/>" +
                        "Нужно создать приложение " +
                        "(SPA приложение в случае frontend, нативное мобильное приложение в случае iOS и Android), " +
                        "в котором на первом экране отображается список категорий новостей, " +
                        "при нажатии на категорию новости происходит переход к списку новостей (обязательно с пейджингом), " +
                        "при нажатии на конкретную новость должен происходить переход к экрану просмотра новости " +
                        "(обратите внимание, что текст новости содержит html).<br/>" +
                        "<br/>" +
                        "В списке категорий должны отображаться только названия категорий.<br/>" +
                        "В списке новостей у каждой новости должны отображаться название, дата, короткое описание.<br/>" +
                        "На экране новости должны отображаться название и короткое описание (сразу), после подгрузки полных данных - должно добавиться полное описание.<br/>" +
                        "Требований к красоте нет. Главное, чтобы функционал совпадал с описанным.",
                "1.0",
                "",
                "",
                "",
                ""
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info)
                .directModelSubstitute(DateTime.class, String.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sebbia.testtask"))
                  .paths(Predicates.not(PathSelectors.regex("/error")))
                  .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false);
    }

}
