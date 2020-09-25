package com.task.madarsoft.appRoomDataBase.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.task.madarsoft.appRoomDataBase.InfoModel;

import java.util.List;

@Dao
public interface classDAO {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertSource(InfoModel infoModel);


     @Query("select * from infomodel;")
     List<InfoModel>getAllSources();

}