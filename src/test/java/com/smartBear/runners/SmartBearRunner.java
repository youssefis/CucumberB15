package com.smartBear.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/smartBear", //feature files
        glue = "com/smartBear/stepDefinition", //step definitions
        dryRun = false, //getting snips without executing
        tags = "@regression2",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
        //and refers to one scenario
        //or refers to multiple scenarios
)

public class SmartBearRunner {
}
