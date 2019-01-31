package com.example.ppriyanka.myapplication.RoomDatabase;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Context context){
        WordDatabase database = WordDatabase.getDatabase(context);
        mWordDao=database.wordDao();
        mAllWords = mWordDao.getAllWord();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new inserAsynctask(mWordDao).execute(word);
    }

    private static class inserAsynctask extends AsyncTask<Word,Void,Void>{

        private WordDao mAsyncDao;

        public inserAsynctask(WordDao mWordDao) {

            this.mAsyncDao=mWordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncDao.insertWord(words[0]);
            return null;
        }
    }
}
