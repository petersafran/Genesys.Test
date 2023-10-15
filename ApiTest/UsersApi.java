package ApiTest;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsersApi extends ApiTestBase{
	
	public UsersApi() {
		super("https://jsonplaceholder.typicode.com/","users");
	}

	public static void main(String[] args) throws URISyntaxException {
		UsersApi api = new UsersApi();
		
		System.out.println(api.url);
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI(api.url + api.endPoint))
				.build();
		
		HttpResponse<String> response = api.sendGetRequest(getRequest);
		
		UserEntity[] users = api.mapUsers(response);
		
		System.out.println("The user list from response:");
		
		for (UserEntity user : users) {
			System.out.println(user.email + " - " + user.name);
		}
		
		System.out.println("The 1st user email address contains @ char: " + api.validateUser(users[0]));
	}
	
	private UserEntity[] mapUsers(HttpResponse<String> response) {
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting();

		Gson gson = builder.create();
		UserEntity[] userEntites = gson.fromJson(response.body().toString(), UserEntity[].class);
		
		return userEntites;
	}
	
	private Boolean validateUser(UserEntity user) {
		return user.email.contains("@");
	}
	
}
