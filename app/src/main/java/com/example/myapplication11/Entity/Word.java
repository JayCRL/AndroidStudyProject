package com.example.myapplication11.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="english_word")
    private String word;
    @ColumnInfo(name="chinese_meaning")
    private String chineseMeaning;
    @ColumnInfo(name = "isShowChinese")
    private boolean isShowChinese;
    @ColumnInfo(name="AddTime")
    private String addTime;

    public boolean getIsShowChinese() {
        return isShowChinese;
    }

    public void setIsShowChinese(boolean isShowChinese) {
        this.isShowChinese = isShowChinese;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
    public Word(String word, String chineseMeaning) {
        this.word=word;
        this.chineseMeaning=chineseMeaning;
    }
    public int getId() {
        return id;
    }
    public String getWord() {
        return word;
    }
    public String getChineseMeaning() {
        return chineseMeaning;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public void setChineseMeaning(String chineseMeaning) {
        this.chineseMeaning = chineseMeaning;
    }
}
