package es.uma.ac.asenjo.myrobot;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioButton rbb;
    RadioButton rbg;
    RadioGroup rg;
    ImageView iv;
    Button bt;
    Resources.Theme t;
    //private myL myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textView);
        rbb=findViewById(R.id.radioButtonblue);
        rbg=findViewById(R.id.radioButtonGreen);
        rg = (RadioGroup) findViewById(R.id.radioGroup2);
        iv = findViewById(R.id.imageView);
        bt = findViewById(R.id.buttonRed);
        t=this.getTheme();
        //myListener = new myL();
        //bt.setOnClickListener(myListener);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setBackgroundColor(Color.RED);
                tv.setTextColor(Color.YELLOW);
            }
        });
    }

    private class myL implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            tv.setBackgroundColor(getResources().getColor(R.color.micolorRojo,t));
            tv.setTextColor(Color.YELLOW);
        }

    }
    public void botonPulsado(View v){
        //tv.setBackgroundColor(getResources().getColor(R.color.colorAccent,this.getTheme()));
        tv.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tv.setTextColor(Color.WHITE);
    }


    public void robotPulsado(View v){
        iv.setImageResource(R.mipmap.ic_launcher_round);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.radioButtonblue:
                tv.setBackgroundColor(0xFF0000ff);
                break;
            case R.id.radioButtonGreen:
                tv.setBackgroundColor(0xFF00ff00);
                break;
        }
//        if (rbb.isChecked()) tv.setBackgroundColor(0xFF0000ff);
//        if (rbg.isChecked()) tv.setBackgroundColor(0xFF00ff00);

    }
}
