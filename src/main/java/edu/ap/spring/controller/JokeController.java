package edu.ap.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {}
       
   /* Method to get joke from URL */
   private String getJokeFromUrl(String inputUrl) {
	   String joke = "All out of jokes!";
		
		try {
			// connect to url
			URL url = new URL(inputUrl);
			URLConnection request = url.openConnection();
		    request.connect();

		    // create a json from received data
		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream)request.getContent()));
		    JsonObject rootobj = root.getAsJsonObject(); 
		    
		    // get the joke
		    String strvalue = rootobj.get("value").toString();
		    JsonElement value = jp.parse(strvalue);
		    JsonObject valueobj = value.getAsJsonObject();
		    
		    joke = valueobj.get("joke").toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return joke;
   }
   
   @RequestMapping("/joke")
   public String joke() {
		return "JokePage";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Map<String, Object> model) {
		String url = "http://api.icndb.com/jokes/random?firstName=" + firstName + "&lastName=" + lastName;	    

		model.put("firstName", firstName);
		model.put("joke", getJokeFromUrl(url));

		return "JokePage";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
