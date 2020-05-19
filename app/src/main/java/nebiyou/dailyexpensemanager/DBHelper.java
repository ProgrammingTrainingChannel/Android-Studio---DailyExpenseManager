package nebiyou.dailyexpensemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by it on 4/29/2009.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context,"DailyDatabase",null,1);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE tbldaily (Date TEXT, reason TEXT , amount TEXT)";
        db.execSQL(query);
    }

    public void AddNewDiary(DailyModel dailyModel){
        ContentValues values = new ContentValues();
        values.put("Date",dailyModel.getDate());
        values.put("reason",dailyModel.getReasone());
        values.put("amount",dailyModel.getAmount());

        SQLiteDatabase db =getWritableDatabase();
        db.insert("tbldaily",null, values) ;


    }

    public DailyModel Search(String Dailydate){
        String query = "SELECT Date, reason,amount FROM tbldaily WHERE Date=?";
        String[] criteria = {Dailydate};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, criteria);

        if(cursor != null){
            cursor.moveToFirst();

            DailyModel dailyModel=new DailyModel();

            dailyModel.setReasone(cursor.getString(1));
            dailyModel.setAmount(cursor.getString(2));
            return dailyModel;
        }
        else{
            return null;
        }



    }

    public List<DailyModel> ShowAll (){
        String query ="SELECT date,reason,amount FROM tbldaily ";
        String[] criteria = {};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, criteria);

        List<DailyModel> dailyModels = new ArrayList<>();
        if(cursor != null){
            cursor.moveToFirst();
            do{
                DailyModel dailyModel=new DailyModel();
                dailyModel.setDate(cursor.getString(0));
                dailyModel.setReasone(cursor.getString(1));
                dailyModel.setAmount(cursor.getString(2));

                dailyModels.add(dailyModel);
            }while(cursor.moveToNext());

            return dailyModels;
        }
        else{
            return null;
        }
    }




        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

}
