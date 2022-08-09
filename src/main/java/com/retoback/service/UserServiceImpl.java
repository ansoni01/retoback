package com.retoback.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.retoback.model.User;
import com.retoback.request.userRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class UserServiceImpl implements UserService {
	
	@Value("${api.public.base.url.usuarios}")
	private String nameService;
	
	@SuppressWarnings("unchecked")
	@Override
	public User listarUsuarios() {
		// TODO Auto-generated method stub
		 ArrayList<String> users = new ArrayList<String>();

		    
		    User oUser = new User();
		    
		      
		    System.out.println("nameService:"+nameService);
		    
		    RestTemplate restTemplate = new RestTemplate();
		    final String baseUrl = nameService;
		    URI uri;
			try {
				uri = new URI(baseUrl);
				   ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
				    
				   if (response.getStatusCodeValue() != 200 || Objects.isNull(response.getBody())) {
					   return null;
		            } else {
		           
		            	  String  resultado = response.getBody();

		                    JsonParser parser = new JsonParser();
		                    JsonElement jsonTree = parser.parse(resultado);
		                    JsonObject jsonObject = jsonTree.getAsJsonObject();
		                    JsonArray  usersArray = jsonObject.getAsJsonArray("data");
		                   
		                    for (JsonElement data : usersArray) {
		                    	 String valoresConcat = "<"+data.getAsJsonObject().get("id").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("last_name").getAsString()+">"+"|"+"<"+data.getAsJsonObject().get("email").getAsString()+">";
		                    	 users.add(valoresConcat);
		                    	 oUser.setData(users);
		                    	}
		            }

				   
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		 
		return oUser;
	}
	
}