package SerializationANDDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationAndDeserialization {
	
	@Test
	void convertPojoToJson() throws JsonProcessingException {
		Student obj=new Student(); //pojo 
		obj.setName("Anuran");
		obj.setLocation("India");
		obj.setPhone("1234567");
		String coursesArr[]= {"C","Java"};
		obj.setCourses(coursesArr);
		//Converting Java Pojo Object to Json Object(Serialzation)
		
		ObjectMapper objectMapper=new ObjectMapper();
		String jsonData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		System.out.println(jsonData);
		
	}
	
	//Converting Json Data to POJO Object(De-serialzation)
	@Test
	void convertJsonToPojo() throws JsonProcessingException {
		
		String jsonData= "{\r\n"
				+ "  \"name\" : \"Anuran\",\r\n"
				+ "  \"location\" : \"India\",\r\n"
				+ "  \"phone\" : \"1234567\",\r\n"
				+ "  \"courses\" : [ \"C\", \"Java\" ]\r\n"
				+ "}";
		
		ObjectMapper objectMapper=new ObjectMapper();
		Student student=objectMapper.readValue(jsonData, Student.class);
		
		System.out.println("Name: "+student.getName());
		System.out.println("Location: "+student.getLocation());
		System.out.println("Phone: "+student.getPhone());
		System.out.println("Course 1 is : "+student.getCourses()[0]);
		System.out.println("Course 2 is : "+student.getCourses()[1]);
	}
}
