package ApiTest;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiTestBase {
	public String url;
	public String endPoint;
	private static HttpClient client;
	
	public ApiTestBase(String where, String endP) {
		url = where;
		endPoint = endP;
		client = HttpClient.newHttpClient();
	}
	
	public HttpResponse<String> sendGetRequest(HttpRequest request) {
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public HttpResponse<String> sendPostRequest(HttpRequest request) {
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
}
