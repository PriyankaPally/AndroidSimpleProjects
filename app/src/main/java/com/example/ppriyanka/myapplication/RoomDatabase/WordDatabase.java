package com.example.ppriyanka.myapplication.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Word.class},version = 1)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    private static volatile WordDatabase INSTANCE;
    static WordDatabase getDatabase(final Context context){

        if (INSTANCE==null){
            INSTANCE= Room
                    .databaseBuilder(context.getApplicationContext(),WordDatabase.class,"word_database")
                    .build();
        }
        return INSTANCE;
    }
}
