package com.example.andriod.registrationformsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
Button btnReg;
EditText txt_id, txt_fname, txt_lname, txt_password, txt_email, txt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Stethod */
//        Stetho.initializeWithDefaults(this);
//        new OkHttpClient.Builder()
//                .addNetworkInterceptor(new StethoInterceptor())
//                .build();
        openHelper = new DatebaseHelper(this);


        btnReg=(Button) findViewById(R.id.btn_Register);
//        txt_id = (EditText) findViewById(R.id.et_ID);
        txt_fname = (EditText) findViewById(R.id.et_Fname);
        txt_lname = (EditText) findViewById(R.id.et_Lname);
        txt_password = (EditText) findViewById(R.id.et_Password);
        txt_email = (EditText) findViewById(R.id.et_Email);
        txt_phone= (EditText) findViewById(R.id.et_Phone);

        btnReg.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                db= openHelper.getWritableDatabase();
                String fname=txt_fname.getText().toString();
                String lname=txt_lname.getText().toString();
                String pass=txt_password.getText().toString();
                String email=txt_email.getText().toString();
                String phone=txt_phone.getText().toString();

                insertData(fname, lname, pass, email, phone);
                Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
            }
        });
        btnReg.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public  boolean onLongClick(View view)
                    {
                        TextView textView = (TextView)findViewById(R.id.textView);
                        textView.setText("Register Successfully, That was long press !");
                        return false;

                    }
                }
        );
    }
    public  void insertData(String fname, String lname, String pass, String email, String phone)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatebaseHelper.COL_2, fname);
        contentValues.put(DatebaseHelper.COL_3, lname);
        contentValues.put(DatebaseHelper.COL_4,pass);
        contentValues.put(DatebaseHelper.COL_5,email);
        contentValues.put(DatebaseHelper.COL_6,phone);

        long id = db.insert(DatebaseHelper.TABLE_NAME, null, contentValues);
    }
}
