package com.bilalmoreno92gmail.myrobot;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioButton rBlue, rGreen;
    RadioGroup rColores;
    ImageView ivAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.texto);
        rBlue = findViewById(R.id.rbtnBlue);
        rGreen = findViewById(R.id.rbtnGreen);
        rColores = findViewById(R.id.rgColores);
        ivAndroid = findViewById(R.id.imageView);
    }

    public void botonRojo(View v){
        //tv.setBackgroundColor(getResources().getColor(R.color.colorAccent, this.getTheme()));
        tv.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        tv.setTextColor(0xFFFFFFFF);
        //                      Color.RED en la clase Color hay muchos colores
    }

    public void robotTouch(View v){
//        if (rBlue.isChecked()){
//            tv.setBackgroundColor(0xFF0000FF);
//        } else if (rGreen.isChecked()){
//            tv.setBackgroundColor(0xFF00FF00);
//        }
        ivAndroid.setImageResource(R.mipmap.ic_launcher_round);
        switch (rColores.getCheckedRadioButtonId()){
            case R.id.rbtnBlue:
                tv.setBackgroundColor(0xFF0000FF);
                break;
            case R.id.rbtnGreen:
                tv.setBackgroundColor(0xFF00FF00);
                break;
        }
    }
}
