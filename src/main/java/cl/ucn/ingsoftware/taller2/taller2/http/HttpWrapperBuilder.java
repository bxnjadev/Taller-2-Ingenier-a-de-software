package cl.ucn.ingsoftware.taller2.taller2.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This class represent the kernel for make request http
 * Follow the design pattern builder for make a process creating
 * the request more easy
 * @param <T>
 */

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

    /**
     * Assign the url
     * @param url the string url
     * @return a builder instance
     */

    public HttpWrapperBuilder<T> url(String url) {
        httpRequestBuilder.uri(
                URI.create(url)
        );

        return this;
    }

    /**
     * Assign a authorization token
     * @param token the string token
     * @return a builder instance
     */

    public HttpWrapperBuilder<T> authenticationBearerToken(String token) {
        httpRequestBuilder.header(
                "Authorization", "Bearer " + token
        );
        return this;
    }

    /**
     * Assign that body to send will be a format json
     * @return a builder instance
     */

    public HttpWrapperBuilder<T> applicationJson() {
        httpRequestBuilder.header("Content-Type", "application/json");
        return this;
    }

    /**
     * Assign the request body
     * @param v the request body
     * @param <V> the type
     * @return a builder instance
     */

    public <V> HttpWrapperBuilder<T> body(V v) {
        body = gson.toJson(v);
        return this;
    }

    /**
     * Set the request type as POST method
     * @return a builder instance
     */

    public HttpWrapperBuilder<T> post() {
        httpRequestBuilder.POST(
                HttpRequest.BodyPublishers.ofString(body)
        );
        return this;
    }

    /**
     * Set the request type as GET method
     * @return a builder instance
     */

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

    /**
     * Create a new request using parameters establish
     * @return the new object requested
     */

    public T build() throws IOException, InterruptedException {
        HttpRequest httpRequest = httpRequestBuilder.build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseAsString = response.body();

        return gson.fromJson(responseAsString, clazz);
    }

}
