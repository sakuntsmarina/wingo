package com.wingo.sakunts.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wingo.sakunts.model.ToDoModel;


public class DataBaseHelp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="TODO _DATABASE";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME ="TODO_TABLE";
    private static final String Col_1 ="ID";
    private static final String Col_2 ="TASK";
    private static final String Col_3 ="STATUS";

    public DataBaseHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME + "(ID INTENGER PRIMARY KEY AUTOINCREMENT, TASK TEXT< STATUS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);


    }
    public void insertTask(ToDoModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,model.getTask());
    }
}
