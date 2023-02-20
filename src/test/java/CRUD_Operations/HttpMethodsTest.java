package CRUD_Operations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpMethodsTest {
	int id;
	@Test(priority = 1)
	void fetchData() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("per_page",equalTo(6))
			.log().all();
	}
	@Test(priority = 2)
	void createUser() {
		HashMap data=new HashMap();
		data.put("name", "Anuran");
		data.put("job", "Developer");
		
		//Fetching the id from the response that is created while creating a new user 
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
//Here dependaOnMethods ensures if createUser is executed then only updateData will execute
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateData() {
		HashMap data=new HashMap();
		data.put("name", "Ron");
		data.put("job", "Developer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id) 		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 4, dependsOnMethods = {"createUser"})
	void deleteData() {
		
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id) 		
		.then()
			.statusCode(204)
			.log().all();
	}
}
