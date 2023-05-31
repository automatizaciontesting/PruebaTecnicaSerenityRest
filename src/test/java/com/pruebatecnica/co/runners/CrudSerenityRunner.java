package com.pruebatecnica.co.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features="src/test/resources/features/CrudSerenity.feature",
        glue = "com.pruebatecnica.co.stepsdefinition",
        snippets = CAMELCASE,
        tags = ""
)
public class CrudSerenityRunner {
}
