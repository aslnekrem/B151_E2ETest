package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepdefinitions","hooks"},//Olusturdugumuz Hooks classini glue kisminda tanimlamamiz gerekir
        tags = "@e2e",
        dryRun = false
)

public class Runner {
/*
25/08/2023
Bugün ne yaptik
Cucumber framework u gelistirdik pom a rest assured ekledik
bas url , hooks (setup het testin basinda calissin diye yoksa spec null verir) olusturduk
pojo olusturduk
runner glue kismina hooks ekledik
tags da sadece calismasini istedigimiz kisimlari ekledik
authenticationmedunna classi sayesinde token aldik
feature file a ekleme yaptik (baslarindaki tag kisimlarini calismasini istedigimiz  sekilde duzenledik)
 */
}
