package com.ravish.universities.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.ravish.universities.R;
import com.ravish.universities.adapter.UniversityAdapter;
import com.ravish.universities.database.UniversityEntity;
import com.ravish.universities.model.University;
import com.ravish.universities.viewModel.UniversityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private UniversityViewModel mViewModel;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private UniversityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            progressBar = findViewById(R.id.progressBar);
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);

            progressBar.setVisibility(View.VISIBLE);
            mViewModel = new ViewModelProvider(this).get(UniversityViewModel.class);

            if (isConnected()){
                fetchUniversityData();
            }else {
                getDataFromTheDatabase();
            }

    }

    private void fetchUniversityData(){
        mViewModel.getAllUniversities("India");

        mViewModel.getUniversityList().observe(this, new Observer<List<University>>() {
            @Override
            public void onChanged(List<University> universities) {
                adapter = new UniversityAdapter(MainActivity.this, universities);
                mViewModel.insertUniversities(universities);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        });

        mViewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                Log.e(TAG, error);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void getDataFromTheDatabase(){
        mViewModel.getAllUniversities().observe(this, new Observer<List<UniversityEntity>>() {
            @Override
            public void onChanged(List<UniversityEntity> entities) {
                mViewModel.getAllDataFromTheDatabase(entities);
            }
        });

        mViewModel.getUniversityList().observe(this, new Observer<List<University>>() {
            @Override
            public void onChanged(List<University> universities) {
                adapter = new UniversityAdapter(MainActivity.this, universities);
                mViewModel.insertUniversities(universities);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}