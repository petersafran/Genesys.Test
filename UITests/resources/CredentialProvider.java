package UITests.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class CredentialProvider {
	
	public Credential getCredentials() throws FileNotFoundException, IOException {
		Credential cred = null;
		try (
				BufferedReader br = new BufferedReader(new FileReader("src\\UITests\\resources\\credentials.json"))) {
				Gson gson = new Gson();	
				cred = gson.fromJson(br, Credential.class);
				System.err.println(cred);
			}
		
		return cred;
	}
}
