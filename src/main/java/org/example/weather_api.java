package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class weather_api {
    public static void main(String[] args) throws Exception {
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("-----------------------------------------");
    	System.out.println("Welcome to Weather app");
    	System.out.println("-----------------------------------------");
    	System.out.println("Enter the Name of the city : ");
    	String city=sc.nextLine();
    	
        String url=String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=2a755173bc4d15a8d13952732bc54c22", city);
        
        HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client=HttpClient.newBuilder().build();
        
        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
 //		Shows the full JSON data
//        System.out.println(response.body()); 
        
        JSONObject jobj=new JSONObject(response.body());
        JSONArray w= (JSONArray)jobj.get("weather");
        
        JSONObject t = (JSONObject)jobj.get("main");
        
        JSONObject d=(JSONObject)w.get(0);
        System.out.println("-----------------------------------------");
        System.out.println("The Weather is :"+d.get("description"));
        var temp=Double.parseDouble(t.get("temp").toString());
        System.out.println("With Current temperature of :"+temp);
        
    }
}
