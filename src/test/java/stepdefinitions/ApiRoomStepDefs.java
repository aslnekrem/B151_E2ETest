package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.RoomPojo;

import java.util.List;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.MedunnaRoomStepDefs.odaId;
import static stepdefinitions.MedunnaRoomStepDefs.odaNo;

public class ApiRoomStepDefs {
    Response response;
    RoomPojo expectedData;

    @Given("GET Request gonderilir")
    public void get_request_gonderilir() {
        //Oda ID'sini alma --> https://medunna.com/api/rooms?sort=createdDate%2Cdesc
        //DIKKAT yukaridaki linkte url'den sonra gelenler pathParam'di fakat "?" ne kadar. ?'den sonra olanlar queryParam yani
            //sorgu parametreleri. Bunu burada ilk defa kullandik buna dikkat et ve asagidaki gibi kullaniliyor.
        spec.pathParams("first", "api", "second", "rooms")
                .queryParam("sort", "createdDate,desc");//burada "," den önce %2C yaziyordu ama hat aldik. UI'daki gibi
        // "," yaptik. Postman otomatik %2C yapmisti onu tekrar buraya kopyalarken düzelttik.
        Response response1 = given(spec).when().get("{first}/{second}");
        Object roomId = response1.jsonPath().getList("findAll{it.roomNumber==" + odaNo + "}.id").get(0); //Buradaki odId önceki testten geliyor o nedenle önce onu calistirmak gerekli.
        System.out.println("Room ID: " + roomId);


        //Set the URL  --> https://medunna.com/api/rooms/72084
        spec.pathParams("first","api","second","rooms","third",odaId); //static yapmayi unutma böylelikle import edip rahatca alabiliyorsun.

        //Set the expected Data
        expectedData = new RoomPojo(odaNo, "SUITE", true, 123.00, "End To End Test için oluşturulmuştur");
        // Send the request and get the response
        response = given(spec).when().get("{first}/{second}/{third}");
    }
    @Then("Body dogrulanir")
    public void body_dogrulanir() throws JsonProcessingException {
        RoomPojo actualData = new ObjectMapper().readValue(response.asString(), RoomPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getRoomNumber(), actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualData.getRoomType());
        assertEquals(expectedData.isStatus(), actualData.isStatus());
        assertEquals(expectedData.getPrice(), actualData.getPrice());
        assertEquals(expectedData.getDescription(), actualData.getDescription());

    }

}
