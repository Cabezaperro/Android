package com.cabezaperro.pjgamboa.examenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private float[] A, B, C;
    int arraySize;
    double time1;
    double time2;
    double time;
    int nth;
    Random rnd = new Random();

    EditText edtSize;
    EditText edtNth;
    TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSize = findViewById(R.id.editTextSize);
        edtNth = findViewById(R.id.editTextNth);
        txvResult = findViewById(R.id.textViewResult);

    // Example of a call to a native method
    // TextView tv = (TextView) findViewById(R.id.sample_text);
    // tv.setText(stringFromJNI());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putDouble("time", time);
        savedInstanceState.putInt("arraySize", arraySize);
        savedInstanceState.putInt("nth", nth);
        savedInstanceState.putFloatArray("A", A);
        savedInstanceState.putFloatArray("B", B);
        savedInstanceState.putFloatArray("C", C);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        time = savedInstanceState.getDouble("time");
        arraySize = savedInstanceState.getInt("arraySize");
        nth = savedInstanceState.getInt("nth");
        A = savedInstanceState.getFloatArray("A");
        B = savedInstanceState.getFloatArray("B");
        C = savedInstanceState.getFloatArray("C");

        txvResult.setText(String.valueOf(time));
    }

    public void initArray(View v)
    {
        if (!edtSize.getText().toString().matches("[0-9]+"))
            Toast.makeText(this, R.string.init_error, Toast.LENGTH_SHORT).show();
        else
        {
            arraySize = Integer.parseInt(edtSize.getText().toString());

            A = new float[arraySize];
            B = new float[arraySize];
            C = new float[arraySize];

            for (int i = 0; i < A.length; i++)
            {
                A[i] = (float) (rnd.nextInt(200) / 100.0) - 1;
                B[i] = (float) (rnd.nextInt(200) / 100.0) - 1;
            }

            Toast.makeText(this, R.string.init_success, Toast.LENGTH_SHORT).show();
        }
    }

    public void compute(View v)
    {
        if (A == null || B == null || C == null)
            Toast.makeText(this, R.string.compute_error, Toast.LENGTH_SHORT).show();
        else
        {
            time1 = System.nanoTime();

            for (int i = 0; i < C.length; i++)
                C[i] = A[i] * B[i];

            time2 = System.nanoTime();
            time = (time2 - time1) / 1000000.0;

            txvResult.setText(String.valueOf(time));
            Toast.makeText(this, R.string.compute_success, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
