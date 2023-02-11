package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Pokemon_api {
    public static void main(String[] args) throws IOException,InterruptedException {
    	
        String url="https://pokeapi.co/api/v2/pokemon/ditto";
        HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client=HttpClient.newHttpClient();
        HttpResponse<String> response= client.send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.statusCode());
        System.out.println(response.body());
        String jsonString=response.body();

//
        JSONObject jobj=new JSONObject(jsonString);

        JSONArray part1= (JSONArray)jobj.get("abilities");
        JSONObject ability= (JSONObject) part1.get(0);
        JSONObject a=ability.getJSONObject("ability");
        String name=a.getString("name");
        String url1="https://pokeapi.co/api/v2/ability/"+name;
        HttpRequest request1=HttpRequest.newBuilder().GET().uri(URI.create(url1)).build();
        HttpResponse<String>response1=client.send(request1,HttpResponse.BodyHandlers.ofString());



        System.out.println(a);

        System.out.println(response1.body());
    }
}