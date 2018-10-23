package com.omin.www.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    CheckBox chkAgree;
    RadioGroup radioGroup;
    RadioButton radioDog;
    RadioButton radioCat;
    RadioButton radioRabbit;
    Button btnOK;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        chkAgree = (CheckBox)findViewById(R.id.chkAgree);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioDog = (RadioButton)findViewById(R.id.radioDog);
        radioCat = (RadioButton)findViewById(R.id.radioCat);
        radioRabbit = (RadioButton)findViewById(R.id.radioRabbit);
        btnOK = (Button)findViewById(R.id.btnOK);
        imageView = (ImageView)findViewById(R.id.imageView);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked())
                    setThisVisibility(VISIBLE);
                else setThisVisibility(INVISIBLE);
            }
        });

        btnOK.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioDog:
                        imageView.setImageResource(R.drawable.dog); break;
                    case R.id.radioCat:
                        imageView.setImageResource(R.drawable.cat); break;
                    case R.id.radioRabbit:
                        imageView.setImageResource(R.drawable.rabbit); break;
                    default:
                        Toast.makeText(getApplication(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void setThisVisibility(int visibleValue) {
        text2.setVisibility(visibleValue);
        radioGroup.setVisibility(visibleValue);
        btnOK.setVisibility(visibleValue);
        imageView.setVisibility(visibleValue);
    }
}
