package net.codejava.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String direHello() {
//		return "Hello";
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Map<String, String>> sayJsonHello() {
//		return new Student(123, "Samir Kumar", "India");
		Map<String, String> hm1 = new HashMap<>();
		hm1.put("password",  "password");
		
		Map<String, String> hm2 = new HashMap<>();
		hm2.put("password",  "p001");
		
		Map<String, String> hm3 = new HashMap<>();
		hm3.put("password",  "p002");
		
		Map<String, Map<String, String>> hm = new HashMap<>();
		hm.put("admin",  hm1);
		hm.put("e001", hm2);
		hm.put("e002", hm3);
		
//		List<Map<String, Map<String, String>>> employees = new ArrayList<>();
//		employees.add(hm);
		
		return hm;
	}
}
