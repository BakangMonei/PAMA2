package com.assignment.onebotanka.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.assignment.onebotanka.Model.User;

import java.util.ArrayList;

public class DAO extends SQLiteOpenHelper {

    SQLiteDatabase db;
    // Creating a constant variables for our database.
    private static final String DB_NAME = "StudentsDB"; // Variable is for our database name.
    private static final int DB_VERSION = 1; // Our database version
    private static final String TABLE_NAME = "Users"; // Variable is for our table name.


    private static final String FIRSTNAME_COL = "firstName"; // Variable is for our firstName column
    private static final String LASTNAME_COL = "lastName"; // Variable is for our lastName column.
    private static final String EMAIL_COL = "email"; // Variable is for our email column.
    private static final String GENDER_COL = "Gender"; // Variable is for our gender column.
    private static final String ADDRESS_COL = "PhysicalAddress"; // Variable is for our address column.
     private static final String DOB_COL = "DateOfBirth"; // Variable is for our DOB column.
    private static final String PHONENUMBER_COL = "PhoneNumber"; // Variable is for our phoneNumber column.
    private static final String PASS_COL = "Password"; // Variable is for our phoneNumber column.
    private static final String REPASS_COL = "RePassWord"; // Variable is for our phoneNumber column.

    // Creating a constructor for our database handler.
    public DAO(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // The table + columns
    public void onCreate(SQLiteDatabase db){
        String query = "Create Table " + TABLE_NAME + "(" +
                FIRSTNAME_COL + " TEXT," +
                LASTNAME_COL + " TEXT," +
                EMAIL_COL + " TEXT," +
                GENDER_COL + " TEXT," +
                ADDRESS_COL + " TEXT," +
                DOB_COL + " TEXT," +
                PHONENUMBER_COL + " TEXT," +
                PASS_COL + " TEXT," +
                REPASS_COL + " TEXT)";
        db.execSQL(query); // At last we are calling a exec sql method to execute above sql query
    }

    // Method for adding new User to our sqlite database.
    public void addNewUser(String email, String firstName, String lastName, String gender, String address, String DOB, String phoneNumber, String pass, String rePass){
        SQLiteDatabase db = this.getWritableDatabase(); // This line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        ContentValues values = new ContentValues();// This line we are creating a variable for content values.

        // Below lines we are passing all values along with its key and value pair.
        values.put(FIRSTNAME_COL, firstName);
        values.put(LASTNAME_COL, lastName);
        values.put(EMAIL_COL, email);
        values.put(GENDER_COL, gender);
        values.put(ADDRESS_COL, address);
        values.put(DOB_COL, DOB);
        values.put(PHONENUMBER_COL, phoneNumber);
        values.put(PASS_COL, pass);
        values.put(REPASS_COL, rePass);

        // After adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null,values);
        // At last we are closing our database after adding database.
        db.close();
    }

    // Method for reading all Users
    public ArrayList<User> readUser(){
        SQLiteDatabase db = this.getReadableDatabase(); // On this line we are creating a database for reading our database.
        Cursor cursorUser = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); // This line we are creating a cursor with query to read data from database.

        ArrayList<User> userArrayList = new ArrayList<>(); // This line we are creating a new array list.
        // Moving our cursor to first position.
        if (cursorUser.moveToFirst()){
            do{
                userArrayList.add(new User(
                        cursorUser.getString(0),
                        cursorUser.getString(1),
                        cursorUser.getString(2),
                        cursorUser.getString(3),
                        cursorUser.getString(4),
                        cursorUser.getString(5),
                        cursorUser.getString(6),
                        cursorUser.getString(7),
                        cursorUser.getString(8)));
            }
            while (cursorUser.moveToNext()); // moving our cursor to next
        }
        // Lastly closing our cursor and returning our array list.
        cursorUser.close();
        return userArrayList;
    }

    // Method for loggingIn
    public void signIn(){
        SQLiteDatabase db = this.getReadableDatabase(); // On this line we are creating a database for reading our database.
        Cursor cursorUser = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); // This line we are creating a cursor with query to read data from database.
    }


    // Method to update student info
    public void updateStudent(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIRSTNAME_COL, user.firstName);
        values.put(LASTNAME_COL, user.lastName);
        values.put(EMAIL_COL, user.email);
        values.put(GENDER_COL, user.gender);
        values.put(ADDRESS_COL, user.address);
        values.put(DOB_COL, user.DOB);
        values.put(PHONENUMBER_COL, user.phoneNumber);
        values.put(PASS_COL, user.password);
        values.put(REPASS_COL, user.rePassword);
        // Updating row
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(user.getEmail())});
        db.close();
    }
    // forgot password for sqlite
    public void changeForgottenPass(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(EMAIL_COL, user.email);
        values.put(PASS_COL, user.password);
        values.put(REPASS_COL, user.rePassword);
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(user.getEmail())});
        db.close();
    }

    // Method for deleting user
    public void deleteUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete user by email
        db.delete(TABLE_NAME, EMAIL_COL + " = ?", new String[] {String.valueOf(user.getEmail())});
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    /*************************************************/
    private SQLiteDatabase openDatabase(){
        String path = TABLE_NAME + DB_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public boolean checkUserExist(String username, String password){
        String[] columns = {"EMAIL_COL"};
        db = openDatabase();

        String selection = "email=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}
