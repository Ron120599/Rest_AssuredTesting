package path_QueryTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class PathAndQueryParameters {
	//Sample URL https://reqres.in/api/users?page=2&id=7
	@Test
	void testQuery_Parameter(){
		given()
		 	.pathParam("mypath","users")
		 	.queryParam("page",2)
		 	.queryParam("id",6)
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
