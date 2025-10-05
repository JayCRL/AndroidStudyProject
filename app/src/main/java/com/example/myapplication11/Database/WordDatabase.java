package com.example.myapplication11.Database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplication11.Dao.WordDao;
import com.example.myapplication11.Entity.Word;
@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDatabase  extends RoomDatabase {
    private static WordDatabase instance;
    //单例模式
    public static synchronized WordDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),WordDatabase.class,"word_database").build();
        }
        return instance;
    }
    public abstract WordDao getWordDao();
}
