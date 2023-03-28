package edu.ewubd.guide;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Matrix4f;

public class Admin_Database extends SQLiteOpenHelper {
    private Context  context;
    private static final String DATABASE_NAME = "Admin.db";

    private static final String TABLE1 = "Fees_Details";
    private static final String F_SID = "S_id";
    private static final String M1 = "Jan";
    private static final String M2 = "Feb";
    private static final String M3 = "Mar";
    private static final String M4 = "Apr";
    private static final String M5 = "May";
    private static final String M6 = "Jun";
    private static final String M7 = "Jul";
    private static final String M8 = "Aug";
    private static final String M9 = "Sep";
    private static final String M10 = "Oct";
    private static final String M11 = "Nov";
    private static final String M12 = "Dec";
    private static final String TABLE2 = "Salary_Details";
    private static final String T_ID = "T_id";
    private static final String Mnt1 = "January";
    private static final String Mnt2 = "February";
    private static final String Mnt3 = "March";
    private static final String Mnt4 = "April";
    private static final String Mnt5 = "May";
    private static final String Mnt6 = "June";
    private static final String Mnt7 = "July";
    private static final String Mnt8 = "August";
    private static final String Mnt9 = "September";
    private static final String Mnt10 = "October";
    private static final String Mnt11 = "November";
    private static final String Mnt12 = "December";

    private static final String TABLE3 = "Notice_Details";
    private static final String Heading = "Heading";


    public Admin_Database(Context context) {
        super(context,DATABASE_NAME,null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("create table "+ TABLE1 + "(S_id TEXT primary key,Jan TEXT,Feb TEXT,Mar TEXT,Apr TEXT,May TEXT,Jun TEXT,Jul TEXT,Aug TEXT,Sep TEXT,Oct TEXT,Nov TEXT,Dec TEXT)");
        MyDB.execSQL("create table "+ TABLE2 + "(T_ID TEXT primary key,January TEXT,February TEXT,March TEXT,April TEXT,May TEXT,June TEXT,July TEXT,August TEXT,September TEXT,October TEXT,November TEXT,December TEXT)");
        MyDB.execSQL("create table "+ TABLE3 + "(Heading TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists "+ TABLE1);
        MyDB.execSQL("drop Table if exists "+ TABLE2);
        MyDB.execSQL("drop Table if exists "+ TABLE3);

    }







    public Boolean addFees(String sid,String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10,String m11,String m12){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(F_SID, sid);
        contentValues.put(M1, m1);
        contentValues.put(M2, m2);
        contentValues.put(M3, m3);
        contentValues.put(M4, m4);
        contentValues.put(M5, m5);
        contentValues.put(M6, m6);
        contentValues.put(M7, m7);
        contentValues.put(M8, m8);
        contentValues.put(M9, m9);
        contentValues.put(M10, m10);
        contentValues.put(M11, m11);
        contentValues.put(M12, m12);
        long result = db.insert("Fees_Details", null, contentValues);


        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertSalary(String tid,String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10,String m11,String m12){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(T_ID, tid);
        contentValues.put(Mnt1, m1);
        contentValues.put(Mnt2, m2);
        contentValues.put(Mnt3, m3);
        contentValues.put(Mnt4, m4);
        contentValues.put(Mnt5, m5);
        contentValues.put(Mnt6, m6);
        contentValues.put(Mnt7, m7);
        contentValues.put(Mnt8, m8);
        contentValues.put(Mnt9, m9);
        contentValues.put(Mnt10, m10);
        contentValues.put(Mnt11, m11);
        contentValues.put(Mnt12, m12);
        long result = db.insert("Salary_Details", null, contentValues);


        if(result==-1) return false;
        else
            return true;
    }

    public Boolean addNotice(String not){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(Heading, not);

        long result = db.insert("Notice_Details", null, contentValues);


        if(result==-1) return false;
        else
            return true;
    }

    public Cursor get_data()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE3;
        Cursor data = db.rawQuery(query,null);
        return data;
    }





    public  Cursor getFees(String ssid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Fees_Details where S_id =?", new String[]{ssid});
        return c;

    }

    public  Cursor getSalary(String tid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from Salary_Details where T_id =?", new String[]{tid});
        return c;

    }



}