package config.frontend.pom_pattern.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@Tag("PageObjects")
@CucumberOptions(
        features = "src/test/resources/features/frontend",
        tags="@E2E",
        glue = {"config.frontend.pom_pattern.definitions"}
)
public class RunnerCustomers {
}
