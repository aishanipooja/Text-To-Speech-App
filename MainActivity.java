package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText Text;
    Button btnText,Clear;
    TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text=findViewById(R.id.Text);
        btnText=findViewById(R.id.btnText);
        Clear=findViewById(R.id.Clear);

        //create an object for textospeech
       textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
           @Override
           public void onInit(int status) {
               //if clause works when there's no error occured
               if(status!=TextToSpeech.ERROR)
               {
                   textToSpeech.setLanguage(Locale.UK);
               }
           }
       });
       //action performing when convert button is pressed
       btnText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
            textToSpeech.speak(Text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

           }
       });
      //action when clear is clicked
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Text.setText("");
            }
        });

    }
}