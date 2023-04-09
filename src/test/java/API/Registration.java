package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Registration {
    @Test
    public void testAPI(){

        User user = new User("eve.holt@reqres.in", "pistol");

        String getUrl = "https://reqres.in";
        String basePathReg = "/api/register";
        String basePathDel = "/api/users/";

        Response creationResponse = given()
                .baseUri(getUrl)
                .contentType(ContentType.JSON)
                .body(user)
                .basePath(basePathReg)
                .post();

        Assert.assertEquals(creationResponse.getStatusCode(),200 );
        ResponseResult expectedRes = new ResponseResult(4, "QpwL5tke4Pnpja7X4");
        ResponseResult actualRes = creationResponse.getBody().as(ResponseResult.class);
        Assert.assertEquals(actualRes.getId(),expectedRes.getId());

        Response deleteResponse = given()
                .baseUri(getUrl)
                .contentType(ContentType.JSON)
                .body(user)
                .basePath(basePathDel + actualRes.getId())
                .delete();

        Assert.assertEquals(deleteResponse.getStatusCode(),204 );



    }

}
