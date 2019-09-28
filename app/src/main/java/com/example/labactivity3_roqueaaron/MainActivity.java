package com.example.labactivity3_roqueaaron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2, input3, input4, input5, input6, input7, input8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 =findViewById(R.id.editText);
        input2 =findViewById(R.id.editText2);
        input3 =findViewById(R.id.editText3);
        input4 =findViewById(R.id.editText4);
        input5 =findViewById(R.id.editText5);
        input6 =findViewById(R.id.editText6);
        input7 =findViewById(R.id.editText7);
        input8 =findViewById(R.id.editText8);
    }

    public void saveData(View v){
        String data1 = input1.getText().toString();
        String data2 = input2.getText().toString();
        String data3 = input3.getText().toString();
        String data4 = input4.getText().toString();
        String data5 = input5.getText().toString();
        String data6 = input6.getText().toString();
        String data7 = input7.getText().toString();
        String data8 = input8.getText().toString();

        String dataAll = data1 + "," + data2 + "," + data3 + "," + data4 + "," + data5 + "," +data6+ "," +data7+ "," +data8;

        String data = dataAll;
        /**/        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());

        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found...");
        }
        catch (IOException e){
            Log.d("Error", "IO Error");
        }
        finally{
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("Error", "File not found...");
            }
            Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();

        }

    }


    public void goNext(View v){
        Intent i = new Intent(getApplicationContext(), Checkbox.class);
        startActivity(i);
    }
}
