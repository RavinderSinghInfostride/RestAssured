package Pages;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DemoRestApi {


    @Test(priority = 1)
    public void toVerifyUserIsAbleToFetchUserListByGetRequest() {
        baseURI = "https://reqres.in";
        given()
                .get("/api/users?page=2")
                .then()
                .statusCode(200).log().all();
    }

    @Test(priority = 2)
    public void toVerifyUserIsAbleToFetchCurrentWeatherByGetRequest() {
        baseURI = "http://api.weatherapi.com/v1";
        given()
                .header("Key", "5cb4034258fb48ffa39125405220211")
                .header("Accept", "application/json")
                .queryParam("q", "Paris")
                .get("/current.json")
                .then()
                .statusCode(200).log().all();
    }

    @Test(priority = 3)
    public void toVerifyUserIsAbleToCreateUserByPostRequest() {
        baseURI = "https://reqres.in";
        JSONObject request = new JSONObject();
        request.put("name", "Ravinder");
        request.put("job", "QA");
        System.out.println(request.toJSONString());
        given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/api/users")
                .then()
                .statusCode(201).log().all();
    }
}