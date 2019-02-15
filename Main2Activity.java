package edu.tamu.ece.mp52;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText answer = (EditText) findViewById(R.id.answer);
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        Integer score = intent.getIntExtra("score", 0);

        if(category.equals("science")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("How many electrons does a hydrogen atom have?");

        } else if(category.equals("harrypotter")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("What is the name of the actress who plays Hermione Granger in the Harry Potter series of films?");
        } else if(category.equals("geography")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("In which Asian country is the city of Chiang Mai located?");
        }

    }

    public void submitAnswer(View view) {
        EditText answer = (EditText) findViewById(R.id.answer);
        Intent intent = getIntent();
        Intent intent2 = new Intent(this, MainActivity.class);
        String category = intent.getStringExtra("category");
        Integer score = intent.getIntExtra("score", 0);


        if(category.equals("science")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("How many electrons does a hydrogen atom have?");

            if(answer.getText().toString().equalsIgnoreCase("One")){
                score++;
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            } else {
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Not correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            }
        } else if(category.equals("harrypotter")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("What is the name of the actress who plays Hermione Granger in the Harry Potter series of films?");
            if(answer.getText().toString().equalsIgnoreCase("Emma Watson")){
                score++;
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            } else {
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Not correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            }
        } else if(category.equals("geography")){
            TextView question = (TextView) findViewById(R.id.Question);
            question.setText("In which Asian country is the city of Chiang Mai located?");
            if(answer.getText().toString().equalsIgnoreCase("Thailand")){
                score++;
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            } else {
                intent2.putExtra("newScore", score);
                Toast.makeText(this, "Not correct!", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent2);
                finish();
            }
        }
    }
}
