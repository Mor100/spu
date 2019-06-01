package com.spu.dong.spu.activity.demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class ContentProviderDemo extends ContentProvider {

    private Context context;

    private UriMatcher urimatch = new UriMatcher(UriMatcher.NO_MATCH);
    @Override
    public boolean onCreate() {
        context = getContext();
        sqLiteDatabase = new DbopenHelperDemo(context).getWritableDatabase();

        urimatch.addURI("com.spu.dong.spu.ContentProviderDemo","myask",0);
        urimatch.addURI("com.spu.dong.spu.ContentProviderDemo","urlcontent",1);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Log.i("dongdong","调用了自定义的query");
        String name = getName(uri);
        return sqLiteDatabase.query(name, strings, s, strings1, null, null, s1, null);


    }

    private String getName(Uri uri){
        int match = urimatch.match(uri);

        switch(match){
            case 0:
                return "myask";
            case 1:
                return "urlcontent";
            default:
                return "null";
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
    private SQLiteDatabase sqLiteDatabase;
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        String name = getName(uri);
        Log.i("myask","调用了自定义的insert");
        sqLiteDatabase.insert(name, null, contentValues);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int count = sqLiteDatabase.delete("myask", s, strings);
        Log.i("dongdong","调用了自定义的delete");
        if (count > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {

        return 0;
    }
}
