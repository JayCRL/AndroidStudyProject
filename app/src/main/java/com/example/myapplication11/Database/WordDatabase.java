package com.example.myapplication11.Database;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication11.Dao.WordDao;
import com.example.myapplication11.Entity.Word;
@Database(entities = {Word.class},version = 5,exportSchema = false)
public abstract class WordDatabase  extends RoomDatabase {
    private static WordDatabase instance;

    //According to the SQL
    static final Migration MIGRATION4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
//            supportSQLiteDatabase.execSQL("ALTER Table word ADD COLUMN test_data VARCHAR(255) DEFAULT  'testData' ");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS word");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS word (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "english_word TEXT, " +
                    "chinese_meaning TEXT, " +
                    "isShowChinese INTEGER NOT NULL DEFAULT 0 , " +
                    "AddTime TEXT)");
        }
    };

    public abstract WordDao getWordDao();

    //单例模式
    public static synchronized WordDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_database")
                    .addMigrations(MIGRATION4_5).build();
        }
        return instance;
    }
}
