package com.example.jsonretrofitplaceholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jsonretrofitplaceholder.adapter.RvRetrofitAdapter;
import com.example.jsonretrofitplaceholder.network.PhotosResults;
import com.example.jsonretrofitplaceholder.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPhotos = findViewById(R.id.rvPhotos);

        getPhotos();
    }

    private void getPhotos() {
        Call<List<PhotosResults>> listCall = RetrofitClient.getInstance().getApi().getPhotos();
        listCall.enqueue(new Callback<List<PhotosResults>>() {
            @Override
            public void onResponse(Call<List<PhotosResults>> call, Response<List<PhotosResults>> response) {
                List<PhotosResults> photosResults = response.body();
                Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                setAdapter(photosResults);

            }

            @Override
            public void onFailure(Call<List<PhotosResults>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void setAdapter(List<PhotosResults> photosResults) {
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));
        RvRetrofitAdapter rvRetrofitAdapter = new RvRetrofitAdapter(this, photosResults);
        rvPhotos.setAdapter(rvRetrofitAdapter);

    }
}