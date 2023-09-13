package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/endtoend_features/TC01_AdminOdaOlusturur.feature",
                "src/test/resources/endtoend_features/TC02_ApiRoom.feature",
                "src/test/resources/endtoend_features/TC03_DataBaseRoom.feature"
        }, //Burada feature'leri sirayla calistirmayi yapiyoruz. Copy path content root yaparak feature'lere.  tag'i da sildik unutma.
        glue = {"stepdefinitions","hooks"},//Olusturdugumuz Hooks classini glue kisminda tanimlamamiz gerekir
        dryRun = false
)
//ui - api - db
//api - ui - db
//db - ui - api
//Yukaridakilerin hepsi E2E test örnekleri
public class E2ERunner {
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
