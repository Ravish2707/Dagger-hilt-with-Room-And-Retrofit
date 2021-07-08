package com.ravish.universities.di;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ravish.universities.constants.UniversityUrls;
import com.ravish.universities.database.UniversityDatabase;
import com.ravish.universities.networking.UniversityApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(UniversityUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public UniversityApiInterface providesUniversityApi(@NonNull Retrofit retrofit){
        return retrofit.create(UniversityApiInterface.class);
    }

    @Provides
    @Singleton
    public UniversityDatabase provideUniversityDatabase(Application application){
        return Room.databaseBuilder(application.getApplicationContext(), UniversityDatabase.class, "university_db")
                .build();
    }
}
