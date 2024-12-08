package mainRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/features/Login.feature"},
//        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        },
        glue = {"steps"}


)

public class MainRunnerTest extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}