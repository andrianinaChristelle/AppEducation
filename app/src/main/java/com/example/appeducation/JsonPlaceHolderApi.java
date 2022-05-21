package com.example.appeducation;

import com.example.appeducation.Model.Matiere;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET ("posts")
    Call<List<Post>> getPosts();

    @GET("getMatiere")
    Call<List<Matiere>> getMatiere();

//    @POST
//    createPost(@Body Matiere matiere)
}
