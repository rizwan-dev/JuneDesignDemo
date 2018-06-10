package com.relfor.demodesignjune;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "felix.sqlite";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "person";

    private static final String NAME = "name";

    private static final String ID = "id";

    private static final String PHONE = "phone";

    private static final String ADDRESS = "address";

    // Database creation
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Table Creation

        String createTableQuery = "create table " + TABLE_NAME + " ( " + ID + " integer primary key autoincrement, "
                + NAME + " text ," + PHONE + " text, " + ADDRESS + " text )";
        db.execSQL(createTableQuery);

    }

    public boolean addPerson(Person person) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, person.getName());
        values.put(ADDRESS, person.getAddress());
        values.put(PHONE, person.getPhone());

        long no = db.insert(TABLE_NAME, null, values);

     /*  if(no == 0){
           return false;
       }
       else {
           return true;
       }*/

        return no > 0;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String query = "select * from " + TABLE_NAME;

        Cursor result = db.rawQuery(query, null);

        if (result.moveToFirst()) {
            do {
                String name = result.getString(result.getColumnIndex(NAME));
                String address = result.getString(result.getColumnIndex(ADDRESS));
                String phone = result.getString(result.getColumnIndex(PHONE));

                Person person = new Person(name, phone, address);
                personList.add(person);

            } while (result.moveToNext());
        }


        return personList;
    }


}
