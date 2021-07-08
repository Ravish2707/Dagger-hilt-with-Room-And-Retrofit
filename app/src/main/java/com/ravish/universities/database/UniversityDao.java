package com.ravish.universities.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<UniversityEntity> universities);

    @Query("DELETE FROM university_table")
    void deleteAllUniversities();

    @Query("SELECT * FROM university_table")
    LiveData<List<UniversityEntity>> getAllUniversities();

}
