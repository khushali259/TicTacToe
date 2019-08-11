package com.example.tictactoe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_MESSAGE1 = "com.example.myfirstapp.MESSAGE1";
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private  int roundCount;
    int player1Points;
    int player2Points;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    Intent intent = getIntent();

    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    String message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_1);

    player1Points = Integer.parseInt(message);
    player2Points = Integer.parseInt(message1);


        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                String buttonID ="button_"+i+j;
                int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);

            }

        }


    }

    @Override
    public void onClick(View v){
        if(!((Button) v).getText().toString().equals("")){
            return;
        }

            if (player1Turn){
                ((Button) v).setText("X");
            }    else{
                ((Button) v).setText("O");
            }
            roundCount++;

            if (checkForWin()){
                if (player1Turn){
                    player1Wins();
             }else {
                  player2Wins();
                }

            }else if(roundCount ==9){
                draw();
            }else{
                player1Turn =!player1Turn;
            }
        }

    private boolean checkForWin(){
        String field[][]= new String[3][3];
        for(int i=0; i<3; i++){
            for (int j =0 ;j<3;j++){
                field[i][j]=buttons[i][j].getText().toString();
            }
        }
        for ( int i = 0; i<3 ; i++){
            if(field[i][0].equals(field[i][1])&& field[i][0].equals(field[i][2])&& !field[i][0].equals("")){
                return true;
            }
        }
        for ( int i = 0; i<3 ; i++){
            if(field[0][i].equals(field[1][i])&& field[0][i].equals(field[2][i])&& !field[0][i].equals("")){
                return true;
            }
        }
        if(field[0][0].equals(field[1][1])&& field[0][0].equals(field[2][2])&& !field[0][0].equals("")){
            return true;
        }
        if(field[0][2].equals(field[1][1])&& field[0][2].equals(field[2][0])&& !field[0][2].equals("")){
            return true;
        }
        return false;
    }
    private void player1Wins(){
        player1Points++;
        Toast.makeText(Main2Activity.this,"Player 1 Wins",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent1=new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra(EXTRA_MESSAGE,Integer.toString(player1Points));
                intent1.putExtra(EXTRA_MESSAGE1,Integer.toString(player2Points));
                startActivity(intent1);
            }
        },3000);

    }
    private void player2Wins(){
        player2Points++;

        Toast.makeText(this,"Player 2 Wins",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1=new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra(EXTRA_MESSAGE,Integer.toString(player1Points));
                intent1.putExtra(EXTRA_MESSAGE1,Integer.toString(player2Points));
                startActivity(intent1);
            }
        },3000);

    }

    private void draw() {
        Toast.makeText(this, "Its a Draw", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1=new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra(EXTRA_MESSAGE,Integer.toString(player1Points));
                intent1.putExtra(EXTRA_MESSAGE1,Integer.toString(player2Points));
                startActivity(intent1);
            }
        },3000);

    }
    }

