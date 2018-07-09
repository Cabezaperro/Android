package es.uma.muii.apdm.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button numButton[] = new Button[10];  // for store number-buttons
    private Button cButton;     // clear button
    private Button dButton;     // delete last digit button
    private Button convButton;  // convert button

    private Integer decNumber = 0;   // decimal number to convert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();                                     // setups listener for buttons
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private class myButtonListener implements Button.OnClickListener {  // listener for button or buttons
        @Override
        public void onClick(View v) {
            // clear button?
            if (cButton.getId() == v.getId()) {
                decNumber = 0;                              // set decimal number to 0
                showDecNumber();                            // show decimal number on the view
            }
        }
    }

    private void setupButtons() {
        // create listener for button/buttons
        myButtonListener mbl = new myButtonListener();
        // register buttons and listener for each button
        cButton = (Button) this.findViewById(R.id.buttonC);
        cButton.setOnClickListener(mbl);
    }

    private void showDecNumber() {
        EditText decView = (EditText) this.findViewById(R.id.editText);  // get reference of decimal number view
        decView.setText(decNumber.toString());                  // set the value of view to the actual decimal number
    }
}
