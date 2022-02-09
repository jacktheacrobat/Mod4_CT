package com.example.mod4_ct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imageViewRoadSign;
    private TextView textViewReaction;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button buttonNextQuestion;
    private String answers[] = getResources().getStringArray(R.array.Answers);
    private int images[] = getResources().getIntArray(R.array.random_images);
    int imagesID[] = getResources().getIntArray(R.array.random_images);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewRoadSign = (ImageView) findViewById(R.id.imageViewRoadSign);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        buttonNextQuestion = (Button) findViewById(R.id.buttonNextQuestion);
        buttonNextQuestion.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                try {
                    MainActivity.this.nextQuestion();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        textViewReaction = (TextView) findViewById(R.id.textViewReaction);
    }

    public void nextQuestion(){

        int correctImgId = randomInt(16);
        TypedArray typedArrayImages = getResources().obtainTypedArray(R.array.random_images);
        imageViewRoadSign.setImageResource(typedArrayImages.getResourceId(correctImgId, 0));
        typedArrayImages.recycle();
        setOptions(correctImgId);
    }

    public void setOptions(int correctImgId){
        int a = randomInt(4);
        switch (a) {
            case 0:
                //Set option 1 to answer
                button1.setText(answers[correctImgId]);
                button2.setText(answers[randomInt(16)]);
                button3.setText(answers[randomInt(16)]);
                button4.setText(answers[randomInt(16)]);
                button1.setOnClickListener(this);

            case 1:
                //Set option 2 to answer
                button1.setText(answers[randomInt(16)]);
                button2.setText(answers[correctImgId]);
                button3.setText(answers[randomInt(16)]);
                button4.setText(answers[randomInt(16)]);
                button2.setOnClickListener(this);

            case 2:
                //Set option 3 to answer
                button1.setText(answers[randomInt(16)]);
                button2.setText(answers[randomInt(16)]);
                button3.setText(answers[correctImgId]);
                button4.setText(answers[randomInt(16)]);
                button3.setOnClickListener(this);

            case 3:
                //Set option 4 to answer
                button1.setText(answers[randomInt(16)]);
                button2.setText(answers[randomInt(16)]);
                button3.setText(answers[randomInt(16)]);
                button4.setText(answers[correctImgId]);
                button4.setOnClickListener(this);
        }
    }

    public static int randomInt(int high) {
        Random random = new Random();
        int randInt = random.nextInt(high);
        return randInt;
    }

    @Override
    public void onClick(View view) {
        textViewReaction.setText("That's correct!");
    }
}