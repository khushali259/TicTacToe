package com.example.tictactoe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    SharedPreferences myPrefs1;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_MESSAGE_1 = "com.example.myfirstapp.MESSAGE_1";
    int player1Points=0;
    int player2Points=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPrefs1 = getSharedPreferences("prefID1", Context.MODE_PRIVATE);

        player1Points = myPrefs1.getInt("Player1Points", 0);
        player2Points = myPrefs1.getInt("Player2Points", 0);

    }
    public void Start(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(player1Points));
        intent.putExtra(EXTRA_MESSAGE_1,Integer.toString( player2Points));
        this.startActivity(intent);
    }
    public void scores(View view){
        myPrefs1 = getSharedPreferences("prefID1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs1.edit();


        try {

            Intent intent1 = getIntent();

            player1Points = Integer.parseInt(intent1.getStringExtra(Main2Activity.EXTRA_MESSAGE));
            player2Points = Integer.parseInt(intent1.getStringExtra(Main2Activity.EXTRA_MESSAGE1));


            Context context = getApplicationContext();
            CharSequence text = "X wins:" + player1Points + "\nO wins:" + player2Points;
            int duration = Toast.LENGTH_LONG;
            editor.putInt("Player1Points", player1Points);
            editor.putInt("Player2Points",player2Points);
            editor.apply();

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "X wins:" + player1Points + "\nO wins:" + player2Points;
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
    }








