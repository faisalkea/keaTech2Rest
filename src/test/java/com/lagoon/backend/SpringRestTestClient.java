package com.lagoon.backend;

import com.lagoon.backend.model.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class SpringRestTestClient {

	//public static final String REST_SERVICE_URI = "http://localhost:8080/Spring4MVCCRUDRestService";
	public static final String REST_SERVICE_URI = "http://localhost:8080/rest";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllUsers(){
		System.out.println("Testing listAllUsers API-----------");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user2/users", List.class);

		if(usersMap!=null){
			for(LinkedHashMap<String, Object> map : usersMap){
				User user = new User();
				int id =  (Integer) map.get("id");
				user.setId((long) id);
				user.setUsername((String)map.get("username"));
				user.setPassword((String)map.get("password"));
				user.setEnabled((String)map.get("enabled"));

				System.out.println("User: " + user);
			}
		}else{
			System.out.println("No user exist----------");
		}
	}
	
	/* GET */
	private static void getUser(){
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user2/1", User.class);
        System.out.println(user);
	}
	
	/* POST */
    private static void createUser() {
		System.out.println("Testing create User API----------");
    	RestTemplate restTemplate = new RestTemplate();
        User user = new User();
		user.setUsername("sarahdoe");
		user.setPassword("secret");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateUser() {
		System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User();
		user.setUsername("sarahdoe2");
		user.setPassword("secret2");
        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
        System.out.println(user);
    }

    /* DELETE */
    private static void deleteUser() {
		System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }


    /* DELETE */
    private static void deleteAllUsers() {
		System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }

    public static void main(String args[]){
		listAllUsers();
//		createUser();
		getUser();
//		listAllUsers();
//		updateUser();
//		listAllUsers();
//		deleteUser();
//		listAllUsers();
//		deleteAllUsers();
//		listAllUsers();
    }
}