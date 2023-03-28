package edu.ewubd.guide;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Login_Database extends SQLiteOpenHelper {
    private Context  context;
    private static final String DATABASE_NAME = "Login.db";
    private static final String TABLE_NAME = "Login_Details";
    private static final String COL1 = "username";
    private static final String COL2 = "password";
    private static final String COL3 = "type";
    private static final String COL4 = "ID";
    private static final String COL5 = "std_name";
    private static final String COL6 = "Full_Name";
    private static final String COL7 = "Phone";

    public Login_Database(Context context) {
        super(context,DATABASE_NAME,null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table "+ TABLE_NAME + "(username TEXT primary key, password TEXT,type TEXT,ID TEXT,std_name TEXT,Full_Name TEXT,Phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists "+ TABLE_NAME);
    }

    public Boolean addData(String username, String password,String type,String std_id,String std_name,String f_name,String phn){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1, username);
        contentValues.put(COL2, password);
        contentValues.put(COL3, type);
        contentValues.put(COL4, std_id);
        contentValues.put(COL5, std_name);
        contentValues.put(COL6, f_name);
        contentValues.put(COL7, phn);

        long result = MyDB.insert(TABLE_NAME, null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean addTeacher(String username, String password,String type,String id,String std_name,String f_name,String phn){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1, username);
        contentValues.put(COL2, password);
        contentValues.put(COL3, type);
        contentValues.put(COL4, id);
        contentValues.put(COL5, std_name);
        contentValues.put(COL6, f_name);
        contentValues.put(COL7, phn);

        long result = MyDB.insert(TABLE_NAME, null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }



    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Login_Details where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }




    public  Cursor ViewData(String key){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Login_Details where username =?", new String[]{key});
        return c;

    }
    public  Cursor ViewStudentID(String key){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Login_Details where username =?", new String[]{key});
        return c;

    }
    public  Cursor ViewTeacherID(String key){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Login_Details where username =?", new String[]{key});
        return c;

    }


}