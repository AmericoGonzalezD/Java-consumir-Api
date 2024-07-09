package com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {//excepcion
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()//obtener del servidor. Este es el builder de la peticion
                .uri(URI.create("http://www.omdbapi.com/?apikey=48892d69&t=Avengers"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());//envia algo

        System.out.println(response.body());
    }
}
