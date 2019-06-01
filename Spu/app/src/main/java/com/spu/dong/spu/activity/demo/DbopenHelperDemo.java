package com.spu.dong.spu.activity.demo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbopenHelperDemo extends SQLiteOpenHelper {

    //数据库名
    private static final String DATA_BASE_NAME = "book.db";
    private static final String BOOK_TABLE_NAME2 = "myask";
    //表名-书
    public static final String BOOK_TABLE_NAME = "urlcontent";
    private final String CREATE_BOOK_TABLE = "create table " + BOOK_TABLE_NAME
            + "(_id integer primary key autoincrement,title text, content text,contenturl text,answer text,gov text,flag text,imagetrueurl text)";

    private final String CREATE_BOOK_TABLE2 = "create table " + BOOK_TABLE_NAME2
            + "(_id integer primary key autoincrement,title text, ask text,image text)";
    public DbopenHelperDemo(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbopenHelperDemo(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DbopenHelperDemo(Context context) {
        super(context, DATA_BASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK_TABLE);
        sqLiteDatabase.execSQL(CREATE_BOOK_TABLE2);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      // sqLiteDatabase.execSQL(CREATE_BOOK_TABLE2);//创建表。
    }
}
