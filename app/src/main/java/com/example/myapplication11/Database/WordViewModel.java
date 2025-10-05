package com.example.myapplication11.Database;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.myapplication11.Entity.Word;
import com.example.myapplication11.Database.WordReposity;

import java.util.List;
public class WordViewModel extends AndroidViewModel {
    WordReposity wordReposity;
    public WordViewModel(@NonNull Application application){
        super(application);
        wordReposity=new WordReposity(application);
    }
    public LiveData<List<Word>> getAllwordsLive(){
        return  wordReposity.getAllwordLists();
    }
    public void InsertWords(Word...words){
        wordReposity.InsertWords(words);
    }
    public void upDateWords(Word...words){
        wordReposity.upDateWords(words);
    }
    public void clearWords(){
      wordReposity.clearWords();
    }
    public void deleteWords(Word...words){
        wordReposity.deleteWords(words);
    }
}
