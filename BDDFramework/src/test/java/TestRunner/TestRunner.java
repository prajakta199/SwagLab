package TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(tags = "", 
features = {"src/test/resources/features" }, 
glue = {"StepDefinition" }, 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner extends AbstractTestNGCucumberTests {
	TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
//
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickle,FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}



