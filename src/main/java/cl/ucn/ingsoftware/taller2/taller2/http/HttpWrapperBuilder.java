package cl.ucn.ingsoftware.taller2.taller2.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpWrapperBuilder<T> {


    private final HttpRequest.Builder httpRequestBuilder = HttpRequest.
            newBuilder();

    private final HttpClient client;
    private final Class<T> clazz;
    private final Gson gson;

    private String body;


    public HttpWrapperBuilder(Class<T> clazz,
                              HttpClient client,
                              Gson gson) {

        this.client = client;
        this.clazz = clazz;
        this.gson = gson;
    }

    public HttpWrapperBuilder<T> url(String url) {
        httpRequestBuilder.uri(
                URI.create(url)
        );

        return this;
    }

    public HttpWrapperBuilder<T> authenticationBearerToken(String token) {
        httpRequestBuilder.header(
                "Authorization", "Bearer " + token
        );
        return this;
    }

    public HttpWrapperBuilder<T> applicationJson() {
        httpRequestBuilder.header("Content-Type", "application/json");
        return this;
    }

    public <V> HttpWrapperBuilder<T> body(V v) {
        body = gson.toJson(v);
        return this;
    }

    public HttpWrapperBuilder<T> post() {
        httpRequestBuilder.POST(
                HttpRequest.BodyPublishers.ofString(body)
        );
        return this;
    }

    public HttpWrapperBuilder<T> get() {
        httpRequestBuilder.GET();
        return this;
    }

    public static <T> HttpWrapperBuilder<T> newBuilder(
            Class<T> clazz,
            HttpClient httpClient,
            Gson gson
    ) {
        return new HttpWrapperBuilder<>(clazz, httpClient, gson);
    }

    public T build() throws IOException, InterruptedException {
        HttpRequest httpRequest = httpRequestBuilder.build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseAsString = response.body();

        return gson.fromJson(responseAsString, clazz);
    }

}
