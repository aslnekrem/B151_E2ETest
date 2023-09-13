package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationMedunna.generateToken;

public class MedunnaBaseUrl {
    //API icin pom.xml'e RestAssured kütüphanesini ekle
    public static RequestSpecification spec;

    //Burada normalde @Before anotasyonu kullaniyoruk Junit ile. Fakat bu proje Cucumber oldugu icin, cucumber
        //da Hooks class icinde Before anotasyonunu kullaniyorduk

    public static void setup(){
        spec = new RequestSpecBuilder(). //Post islemi icin Content type'i eklemeyi unutma. Post isleminde kullaniyorduk
                setContentType(ContentType.JSON).
                addHeader("Authorization","Bearer "+generateToken()). //Bu generateToken() token alma method'unu yaptiktan sonra buraya addHeader ile bu sekilde eklemeyi unutma
                setBaseUri("https://medunna.com").
                build();
    }
}
