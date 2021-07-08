package com.ravish.universities.repository;


import androidx.lifecycle.LiveData;

import com.ravish.universities.database.UniversityDatabase;
import com.ravish.universities.database.UniversityEntity;
import com.ravish.universities.model.University;
import com.ravish.universities.networking.UniversityApiInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class UniversityRepository {

    private UniversityApiInterface apiInterface;
    private UniversityDatabase database;

    @Inject
    public UniversityRepository(UniversityApiInterface apiInterface, UniversityDatabase database){
        this.apiInterface = apiInterface;
        this.database = database;
    }

    public Call<List<University>> getAllUniversities(String country){
        return apiInterface.getAllUniversities(country);
    }

    public void insert(List<UniversityEntity> universities){
        UniversityDatabase.databaseExecutor.execute(() -> {
            database.universityDao().insert(universities);
        });
    }

    public void deleteAllUniversities(){
        UniversityDatabase.databaseExecutor.execute(()->{
            database.universityDao().deleteAllUniversities();
        });
    }

    public LiveData<List<UniversityEntity>> getAllUniversities(){
        return database.universityDao().getAllUniversities();
    }
}
