package com.example.ppriyanka.myapplication.Retrofit;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.ppriyanka.myapplication.R;
import com.example.ppriyanka.myapplication.databinding.ActivityPhotoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    ActivityPhotoBinding binding;
    PhotoAdatapter photoAdatapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_photo);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_photo);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();

        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {

                progressDialog.dismiss();

                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {

                progressDialog.dismiss();

                Toast.makeText(PhotoActivity.this, "Something went wrong please try again", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void generateDataList(List<RetroPhoto> photoList) {

        photoAdatapter = new PhotoAdatapter(this,photoList);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(photoAdatapter);

    }
}
