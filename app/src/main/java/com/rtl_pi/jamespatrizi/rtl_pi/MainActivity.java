package com.rtl_pi.jamespatrizi.rtl_pi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button execute_button;
    private String[] modeSpinner;

    private Toast toastFromEditText(EditText text) {
        return Toast.makeText(this, text.getText().toString(), Toast.LENGTH_LONG);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set view of activity_main.xml
        setContentView(R.layout.activity_main);

        //Create Modulation Mode Spinner
        this.modeSpinner = new String[] {
                "WBFM", "AM", "USB", "LSB"
        };
        Spinner s = (Spinner) findViewById(R.id.modeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, modeSpinner);
        s.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //end spinner

        //Create execute button listener
        execute_button = (Button) findViewById(R.id.execute);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.Hz_Input);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast = toastFromEditText(text);
                toast.show();
            }
        });//end execute listener
    }//end onCreate
}

