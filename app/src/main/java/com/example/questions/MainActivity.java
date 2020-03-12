package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    private RecyclerView poolplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        initRecyclerView();

        ImageView plus = (ImageView) findViewById(R.id.plus_click);
        ImageView play = (ImageView) findViewById(R.id.check_click);

        plus.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //final View new_player = LayoutInflater.from(getApplicationContext()).inflate(R.layout.new_player, pool_player);


            }
        });

        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                SQLiteDatabase database = dbHelper.getWritableDatabase();
                final ViewGroup pool_player = (ViewGroup) findViewById(R.id.player_pool);
                ContentValues contentValues = new ContentValues();
                int t = 0;

                for (int i = 0; i < pool_player.getChildCount(); i++){
                    LinearLayout player = (LinearLayout) pool_player.getChildAt(i);
                    for(int j = 0; j < player.getChildCount(); j ++){
                        RadioGroup rgr = (RadioGroup) player.getChildAt(0);
                        EditText tplayer = (EditText) player.getChildAt(1);
                        if (tplayer.length() > 0) {
                            if (rgr.getCheckedRadioButtonId() != -1) {
                                t++;
                                if (j == rgr.getCheckedRadioButtonId())
                                {
                                    String name = String.valueOf(tplayer.getText());
                                    int sex = j;

                                    contentValues.put(DBHelper.KEY_NAME, name);
                                    contentValues.put(DBHelper.KEY_SEX, sex);

                                    database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                                }
                            }
                            else {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Выберите пол для каждого игрока", Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Заполните все текстовые поля", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }

                }

                if (t/3 == pool_player.getChildCount())
                {
                    Log.d("228", "start");
                }
            }
        });

    }

    private void initRecyclerView(){
        poolplayer = findViewById(R.id.player_pool);
        poolplayer.setLayoutManager(new LinearLayoutManager(this));
    }

}
