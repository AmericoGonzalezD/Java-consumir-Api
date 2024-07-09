package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {//excepcion
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de la pelicula");
        var busqueda = lectura.nextLine();

        String direccion = "http://www.omdbapi.com/?apikey=48892d69&t="+busqueda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()//obtener del servidor. Este es el builder de la peticion
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());//envia algo

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Titulo miTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(miTitulo.toString());
    }
}
