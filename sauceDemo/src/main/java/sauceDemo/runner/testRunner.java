package sauceDemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features= {"src/main/resources/Features"},
glue = {"sauceDemo.StepDef"},
plugin= {"pretty", "html:target/htmlreport.html"})

public class testRunner extends AbstractTestNGCucumberTests {

}
