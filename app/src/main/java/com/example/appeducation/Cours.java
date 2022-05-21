package com.example.appeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appeducation.Model.Matiere;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cours extends AppCompatActivity {

    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrotif = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrotif.create(JsonPlaceHolderApi.class);
        Call<List<Matiere>> call = jsonPlaceHolderApi.getMatiere();
        call.enqueue(new Callback<List<Matiere>>() {
            @Override
            public void onResponse(Call<List<Matiere>> call, Response<List<Matiere>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code:"+ response.code());
                    return;
                }
                List<Matiere> posts = response.body();
                for(Matiere post :posts){
                    String content ="";
                    content +="ID: " + post.getName() +"\n";
                    textViewResult.append(content);
                    System.out.println("okiii"+content);
                }
            }

            @Override
            public void onFailure(Call<List<Matiere>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
                System.out.println("okiii"+t.getMessage());
            }
        });

    }
}