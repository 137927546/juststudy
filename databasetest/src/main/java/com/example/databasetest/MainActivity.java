package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

import java.util.List;

/**
 * https://github.com/LitePalFramework/LitePal
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
//        如果更新表则version必须大于之前
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDatabase = findViewById(R.id.create_database);


        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create and/or open a database that will be used for reading and writing.
//                dbHelper.getWritableDatabase();

                //使用 litePal
                SQLiteDatabase db = LitePal.getDatabase();
            }
        });

        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                //开始组装第一条数据
//                values.put("name","The Da Vinci Code");
//                values.put("author","Dan Brown");
//                values.put("pages",454);
//                values.put("price",16.96);
//                db.insert("Book",null,values);//插入第一条数据
//                values.clear();
//
//                //开始组装第二条数据
//                values.put("name","The Lost Symbol");
//                values.put("author","Dan Brown");
//                values.put("pages",510);
//                values.put("price",19.95);
//                db.insert("Book",null,values);//插入第二条数据

                //方式二
//                db.execSQL("insert into Book (name,author,pages,price) values(?,?,?,?)",new String[]{"The Da Vinci Code","Dan Brown" ,"454","16.96"});
//                db.execSQL("insert into Book (name,author,pages,price) values(?,?,?,?)",new String[]{"The Lost Symbol","Dan Brown" ,"510","19.95"});

                //litepal
                Books books = new Books();
                books.setName("The Liu Da Xian Code");
                books.setAuthor("Liu");
                books.setPages(666);
                books.setPrice(88.88);
                books.setPress("UnKnow");
                books.save();


            }
        });

        Button updateData = findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新数据
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("price",10.99);
//                db.update("Book",values,"name = ?",new String[]{"The Da Vinci Code"});

                //方式二
//                db.execSQL("update Book set  price = ? where name = ? ",new String[]{"10.99","The Da Vinci Code"});


                //litepal
                Books books = new Books();
                books.setName("The Da Vinci Code");
                books.setAuthor("Vinci");
                books.setPages(510);
                books.setPrice(19.69);
                books.setPress("UnKnow");
                books.save();
                books.setPrice(10.99);
                books.save();


            }
        });

        Button deleteData = findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.delete("Book","pages > ?",new String[]{"500"});
//
//                //方式二
//                db.execSQL("delete from Book where pages > ?",new String[]{"500"});

                //litepal
//                LitePal.delete(Books.class, 1);
                LitePal.deleteAll(Books.class, "price > ?" , "20.00");
            }
        });

        Button queryData = findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                //查询Book表中所有数据
//                Cursor cursor = db.query("Book", null, null, null, null, null, null);

                //方式二
//                Cursor cursor = db.rawQuery("select * from Book", null);

//                if (cursor.moveToFirst()) {
//                    do{
//                        //遍历Cursor对象，取出数据并打印
//                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        String author = cursor.getString(cursor.getColumnIndex("author"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
//
//                        Log.d(TAG, "book name is " + name);
//                        Log.d(TAG, "book author is " + author);
//                        Log.d(TAG, "book pages is " + pages);
//                        Log.d(TAG, "book price is " + price);
//
//                        /**
//                         * Move the cursor to the next row.
//                         *
//                         * <p>This method will return false if the cursor is already past the
//                         * last entry in the result set.
//                         *
//                         * @return whether the move succeeded.
//                         *
//                         * cursor.moveToNext()
//                         */
//                    }while (cursor.moveToNext());
//                }
//                cursor.close();

                List<Books> all = LitePal.findAll(Books.class);

                for (Books books : all) {
                    Log.d(TAG, "name : "+ books.getName());
                    Log.d(TAG, "name : "+ books.getPrice());
                }
            }
        });
    }
}
