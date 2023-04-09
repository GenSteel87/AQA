package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RegistrationByAPI {
    @Test
    public void testAPI(){

        NewUser newUser = new NewUser("eve.holt@reqres.in", "pistol");

        String getUrl = "https://reqres.in";
        String basePathReg = "/api/register";
        String basePathDel = "/api/users/";

        Response res = given()
                .baseUri(getUrl)
                .contentType(ContentType.JSON)
                .body(newUser)
                .basePath(basePathReg)
                .post();

        Assert.assertEquals(res.getStatusCode(),200 );

        Resp expectedRes = new Resp(4, "QpwL5tke4Pnpja7X4");
        Resp actualRes = res.getBody().as(Resp.class);
        Assert.assertEquals(actualRes.getId(),expectedRes.getId());

        System.out.println("User creation - response status is " + res.getStatusCode());

        Response del = given()
                .baseUri(getUrl)
                .contentType(ContentType.JSON)
                .body(newUser)
                .basePath(basePathDel + actualRes.getId())
                .delete();

        Assert.assertEquals(del.getStatusCode(),204 );



    }

}
