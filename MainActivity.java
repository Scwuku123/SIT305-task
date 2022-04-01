package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int select;
    ImageView btn1,btn2,btn3;
    EditText input;
    TextView show11,show12,show21,show22,show31,show32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp=findViewById(R.id.sp);
        input=findViewById(R.id.input);
        show11=findViewById(R.id.show11);
        show12=findViewById(R.id.show12);
        show21=findViewById(R.id.show21);
        show22=findViewById(R.id.show22);
        show31=findViewById(R.id.show31);
        show32=findViewById(R.id.show32);
        List<String> splists=new ArrayList<>();
        splists.add("Metre");
        splists.add("Celsius");
        splists.add("Kilograms");
        ArrayAdapter<String>  adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, splists);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn1=findViewById(R.id.btn1);
       btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        resetShow();
        String s = input.getText().toString();
        if (s.isEmpty()){
            ToastUtils.show(this," input is empty");
            return;
        }
        switch (view.getId()){
            case R.id.btn1:
                if (select!=0){
                    ToastUtils.show(this,"Please select the correct conversion icon");
                }else{
                    calculate1(Double.valueOf(s));
                }
                break;
            case R.id.btn2:
                if (select!=1){
                    ToastUtils.show(this,"Please select the correct conversion icon");
                }else{
                    calculate2(Double.valueOf(s));
                }
                break;
            case R.id.btn3:
                if (select!=2){
                    ToastUtils.show(this,"Please select the correct conversion icon");
                }else{
                    calculate3(Double.valueOf(s));
                }
                break;

        }
    }

    private void calculate3(Double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        String gram = df.format(d*1000.0);
        String ounce=df.format(d*35.273968);
        String pound=df.format(d*2.2046);
        show11.setText(gram);
        show12.setText("Gram");
        show21.setText(ounce);
        show22.setText("Ounce(Oz)");
        show31.setText(pound);
        show32.setText("Pound(lb)");
    }

    private void calculate2(Double input) {
        DecimalFormat df = new DecimalFormat("0.00");
        String fahrenheit = df.format(1.8*input+32.0);
        String kelvin=df.format(input+273.15);
        show11.setText(fahrenheit);
        show12.setText("Fahrenheit");
        show21.setText(kelvin);
        show22.setText("Kelvin");
    }

    private void calculate1(double input) {

        double ft =input * 3.2808;
        double yc=input*39.3701;
        DecimalFormat df = new DecimalFormat("0.00");
        String foot = df.format(ft);
        String inch=df.format(yc);
        String metre=df.format(input*100);
        show11.setText(metre);
        show12.setText("Centimetre");
        show21.setText(foot);
        show22.setText("Foot");
        show31.setText(inch);
        show32.setText("inch");

    }

    private void resetShow() {
        show11.setText("");
        show12.setText("");
        show21.setText("");
        show22.setText("");
        show31.setText("");
        show32.setText("");

    }
}