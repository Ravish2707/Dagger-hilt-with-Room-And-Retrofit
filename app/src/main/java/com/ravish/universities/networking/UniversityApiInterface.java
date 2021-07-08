package com.ravish.universities.networking;


import com.ravish.universities.constants.UniversityUrls;
import com.ravish.universities.model.University;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UniversityApiInterface {

    @GET(UniversityUrls.END_POINT_URL)
    Call<List<University>> getAllUniversities(@Query("country") String country);

}
