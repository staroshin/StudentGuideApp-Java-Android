package edu.ewubd.guide;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Matrix4f;

public class Teacher_Database extends SQLiteOpenHelper {
    private Context  context;
    private static final String DATABASE_NAME = "Teacher.db";
    private static final String TABLE = "Homework_Details";
    private static final String COL1 = "Title";
    private static final String COL2 = "Date";

    private static final String TABLE2 = "Grade_Details";
    private static final String SID = "Sid";
    private static final String H_GRADE = "H_Grade";
    private static final String A_GRADE = "A_Grade";


    public Teacher_Database(Context context) {
        super(context,DATABASE_NAME,null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table "+ TABLE + "(Title TEXT,Date TEXT)");
        MyDB.execSQL("create table "+ TABLE2 + "(Sid TEXT primary key,H_Grade TEXT,A_Grade)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists "+ TABLE);
        MyDB.execSQL("drop Table if exists "+ TABLE2);
    }




    public Boolean addValue(String title,String date){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(COL1, title);
        contentValues.put(COL2, date);
        long result = MyDB.insert(TABLE, null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean addGrade(String sid,String h_grade,String a_grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(SID, sid);
        contentValues.put(H_GRADE, h_grade);
        contentValues.put(A_GRADE, a_grade);
        long result = db.insert("Grade_Details", null, contentValues);


        if(result==-1) return false;
        else
            return true;
    }



    public Cursor get_data()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


    public Integer deleteDataByKey(String t) {
        SQLiteDatabase db = this.getWritableDatabase();
        int isDeleted = 0;

            isDeleted = db.delete(TABLE, COL1 + " = ?", new String[] { t });

        return isDeleted;
    }
    public  Cursor getGrade(String ssid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Grade_Details where Sid =?", new String[]{ssid});
        return c;

    }






}