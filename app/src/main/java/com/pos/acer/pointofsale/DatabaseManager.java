package com.pos.acer.pointofsale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



/**
 * Created by Daly on 7/11/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context) {
        super(context,Constructor.DATABASE_NAME ,null, 1);
        SQLiteDatabase database = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constructor.CREATE_TABLE_USER);
        db.execSQL(Constructor.CREATE_TABLE_PRODUCT);
        db.execSQL(Constructor.CREATE_TABLE_PRODUCT_TYPE);
        db.execSQL(Constructor.CREATE_TABLE_PROMOTION);
        db.execSQL(Constructor.CREATE_TABLE_RECEIPT);
        db.execSQL(Constructor.CREATE_TABLE_PRODUCT_RECORD);
        db.execSQL(Constructor.CREATE_TABLE_RECEIPT_RECORD);
        db.execSQL(Constructor.CREATE_TABLE_PRODUCT_PROMOTION);
        db.execSQL(Constructor.CREATE_TABLE_USER_PRODUCT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constructor.DROP_TABLE_USER);
        db.execSQL(Constructor.DROP_TABLE_PRODUCT);
        db.execSQL(Constructor.DROP_TABLE_PRODUCT_TYPE);
        db.execSQL(Constructor.DROP_TABLE_PROMOTION);
        db.execSQL(Constructor.DROP_TABLE_RECEIPT);
        db.execSQL(Constructor.DROP_TABLE_PRODUCT_RECORD);
        db.execSQL(Constructor.DROP_TABLE_RECEIPT_RECORD);
        db.execSQL(Constructor.DROP_TABLE_PRODUCT_PROMOTION);
        db.execSQL(Constructor.DROP_TABLE_USER_PRODUCT);
    }
    //  INSERT USER DATA TO TABLE IN DATABASE
    public boolean AddUser(User user)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constructor.TBU_FULLNAME,user.getFullname());
        contentValues.put(Constructor.TBU_USERNAME,user.getUsername());
        contentValues.put(Constructor.TBU_GENDER,user.getGender());
        contentValues.put(Constructor.TBU_AGE,user.getAge());
        contentValues.put(Constructor.TBU_DATE_OF_BIRTH,user.getDateOfBirth());
        contentValues.put(Constructor.TBU_ADDRESS,user.getAddress());
        contentValues.put(Constructor.TBU_PHONE,user.getPhoneNumber());
        contentValues.put(Constructor.TBU_PASSWORD,user.getPassword());
        contentValues.put(Constructor.TBU_EMAIL,user.getEmail());
        contentValues.put(Constructor.TBU_IMG_PROFILE,user.getImgProfile());
        contentValues.put(Constructor.TBU_ROLE,user.getRole());

        long result = database.insert(Constructor.TABLE_USER,null,contentValues);
        database.close();
        if(result == -1) return false;
        else return true;
    }
    public boolean verifyUser(String username)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From "
                +Constructor.TABLE_USER+" Where "+Constructor.TBU_USERNAME+" = ? ",new String[]{username});
        if(cursor.moveToNext()) return false;
        cursor.close();
        sqLiteDatabase.close();
        return true;
    }

    public User userLogin(String username,String password)
    {
        User user = new User();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From "
                +Constructor.TABLE_USER+" Where "+Constructor.TBU_USERNAME+" = ? and "
                +Constructor.TBU_PASSWORD+" = ?",new String[]{username,password});
        if(cursor.moveToNext())
        {
            user.setUserId(cursor.getInt(0));
            user.setFullname(cursor.getString(1));
            user.setUsername(username);
            user.setGender(cursor.getString(3));
            user.setAge(cursor.getInt(4));
            user.setDateOfBirth(cursor.getString(5));
            user.setAddress(cursor.getString(6));
            user.setPhoneNumber(cursor.getString(7));
            user.setEmail(cursor.getString(8));
            user.setPassword(password);
            user.setImgProfile(cursor.getString(10));
            user.setRole(cursor.getString(11));
            return user;
        }
        cursor.close();
        sqLiteDatabase.close();
        return null;
    }
    public ArrayList<User> getAllUser()
    {
        ArrayList<User> users = new ArrayList<User>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From "+Constructor.TABLE_USER,null);
        while (cursor.moveToNext())
        {
            User user = new User();
            user.setUserId(cursor.getInt(0));
            user.setFullname(cursor.getString(1));
            user.setUsername(cursor.getString(2));
            user.setGender(cursor.getString(3));
            user.setAge(cursor.getInt(4));
            user.setDateOfBirth(cursor.getString(5));
            user.setAddress(cursor.getString(6));
            user.setPhoneNumber(cursor.getString(7));
            user.setEmail(cursor.getString(8));
            user.setPassword(cursor.getString(9));
            user.setImgProfile(cursor.getString(10));
            user.setRole(cursor.getString(11));
            users.add(user);
        }
        cursor.close();
        sqLiteDatabase.close();
        if(!users.isEmpty()) return users;
        else return null;
    }
    public Boolean deleteUser(int userId)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.delete(Constructor.TABLE_USER,Constructor.TBUP_USER_ID+" = ? ",new String[]{userId+""});
        sqLiteDatabase.close();
        if(result==-1) return false;
        else return true;
    }


}
