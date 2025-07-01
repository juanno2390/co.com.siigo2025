package config.backend.runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Assert;
import org.junit.Test;

public class RunnerReqreIn {
    @Test
    public void testKarate()
    {
        System.setProperty("logback.configurationFile", "src/test/resources/logback-test.xml");

        Results results = Runner.path("classpath:features/backend").tags("@Regresion").parallel(6);
        Assert.assertEquals(results.getErrorMessages(), results.getFailCount(),0);
    }
}
