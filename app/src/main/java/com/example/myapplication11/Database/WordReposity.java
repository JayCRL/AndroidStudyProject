package com.example.myapplication11.Database;
import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.myapplication11.Dao.WordDao;
import com.example.myapplication11.Entity.Word;
import java.util.List;
public class WordReposity {
    private LiveData<List<Word>> allwordLists;
    private WordDao wordDao;
    public WordReposity(Context context){
        WordDatabase wordDatabase=WordDatabase.getInstance(context.getApplicationContext());
        wordDao=wordDatabase.getWordDao();
        allwordLists=wordDao.getAllWords();
    }
    public LiveData<List<Word>> getAllwordLists(){
        return  allwordLists;
    }
    public void InsertWords(Word...words){
        new InsertAsyncTask(wordDao).execute(words);
    }
    public void upDateWords(Word...words){
        new UpdateAsyncTask(wordDao).execute(words);
    }
    public void clearWords(){
        new ClearAsyncTask(wordDao).execute();
    }
    public void deleteWords(Word...words){
        new DeleteAsyncTask(wordDao).execute(words);
    }
    private static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDao wordDao;
        public InsertAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {//后台进行的操作
            wordDao.insertwords(words);
            return  null;
        }
    }
    private static class ClearAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;
        public ClearAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {//后台进行的操作
            wordDao.deleteAllWords();
            return  null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;
        public UpdateAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {//后台进行的操作
            wordDao.updateWords(words);
            return  null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;
        public DeleteAsyncTask(WordDao wordDao){
            this.wordDao=wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {//后台进行的操作
            wordDao.deleteWords(words);
            return  null;
        }
    }
}
