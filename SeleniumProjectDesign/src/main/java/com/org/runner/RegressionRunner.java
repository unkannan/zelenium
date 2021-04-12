package com.org.runner;
 

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags= {"@tag"},features= {"src/test/resources/features"},glue= {"stepdefinitions"}
, monochrome = true)
public class RegressionRunner {

}

 

 
