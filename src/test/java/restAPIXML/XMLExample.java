package restAPIXML;

import org.testng.annotations.Test;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLExample {
	
	@Test
	public void Test() {
		
		RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println(response.getBody().asString());
	
		//This is again restAssured library which will import xml
		NodeChildrenImpl AllBooks = response.then().extract().path("bookstore.book.title");
		
		System.out.println(AllBooks);
		System.out.println("First book is " + AllBooks.get(0));
		System.out.println("Second book is " + AllBooks.get(1));
		System.out.println("First book Language is " + AllBooks.get(0).getAttribute("lang"));
		System.out.println("Second book Language is " + AllBooks.get(0).getAttribute("lang"));
	}

}
