package com.org.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/resources/features/ApiPostFeature.feature"},glue= {"stepdefinitions"},tags= {}
, monochrome = true)
public class RegressionFeatureRun {

}
