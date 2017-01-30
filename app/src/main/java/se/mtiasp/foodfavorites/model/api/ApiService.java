package se.mtiasp.foodfavorites.model.api;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import rx.Observable;

import se.mtiasp.foodfavorites.model.api.response.FoodResponse;

public interface ApiService {
    @GET("{query}")
    Observable<Response<FoodResponse>> getFood(@Header("Authorization") String token, @Path("query") String query);
}
