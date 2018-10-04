package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class lab2 extends AppCompatActivity {

    EditText gamer;
    TextView status;
    RadioButton radiobutton;
    RadioButton radiobutton2;
    RadioButton radiobutton3;
    RadioGroup radiogroup;
    Button play;
    TextView name;
    TextView winner;
    TextView mymora;
    TextView computermora;

    int mora_gamer = -1;
    String[] MoraString = {"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        gamer = (EditText) findViewById(R.id.editText);
        status = (TextView) findViewById(R.id.textView2);
        radiobutton = (RadioButton) findViewById(R.id.radioButton3);
        radiobutton2 = (RadioButton) findViewById(R.id.radioButton2);
        radiobutton3 = (RadioButton) findViewById(R.id.radioButton);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        play = (Button) findViewById(R.id.button2);
        name = (TextView) findViewById(R.id.textView16);
        winner = (TextView) findViewById(R.id.textView17);
        mymora = (TextView) findViewById(R.id.textView18);
        computermora = (TextView) findViewById(R.id.textView19);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radiogroup.getCheckedRadioButtonId()){
                    case R.id.radioButton3:
                        mora_gamer=0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer=1;
                        break;
                    case R.id.radioButton:
                        mora_gamer=2;
                        break;
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gamer.getText().toString().equals(""))
                    status.setText("請選擇玩家名稱");
                else if(mora_gamer == -1)
                    status.setText("請選擇出拳種類");
                else{
                    name.setText(gamer.getText());
                    mymora.setText(MoraString[mora_gamer]);
                    int mora_computer = (int)(Math.random()*3);
                    computermora.setText(MoraString[mora_computer]);
                    if((mora_gamer == 0 && mora_computer == 1)||(mora_gamer == 1 && mora_computer == 2)||(mora_gamer == 2) && mora_computer == 0){
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    }else if(mora_computer == mora_gamer){
                        winner.setText("平局");
                        status.setText("平局!再試一場看看");
                    }else{
                        winner.setText(gamer.getText());
                        status.setText("恭喜你獲勝了");
                    }

                }
            }
        });
    }


}
