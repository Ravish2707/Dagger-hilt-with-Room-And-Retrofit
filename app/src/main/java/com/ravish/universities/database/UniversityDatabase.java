package com.ravish.universities.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = UniversityEntity.class, version = 1, exportSchema = false)
public abstract class UniversityDatabase extends RoomDatabase {

    public abstract UniversityDao universityDao();

    public static final ExecutorService databaseExecutor = Executors.newSingleThreadExecutor();

}
