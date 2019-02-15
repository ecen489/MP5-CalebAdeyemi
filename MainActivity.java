package edu.tamu.ece.mp52;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void JumpToQuestion(View view) {
        TextView score = (TextView) findViewById(R.id.Score);
        String currentScore = (String) score.getText();
        Integer currentScoreInt = Integer.valueOf(currentScore);
         Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("score", currentScoreInt);

        if(view.getId() == R.id.Science){
            intent.putExtra("category", "science");
        } else if (view.getId() == R.id.HarryPotter){
            intent.putExtra("category", "harrypotter");
        } else if (view.getId() == R.id.Geography){
            intent.putExtra("category", "geography");
        }
        startActivityForResult(intent,REQ_CODE);

    }

    public void ResetScore(View view) {
        TextView score = (TextView) findViewById(R.id.Score);
        score.setText("0");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == REQ_CODE){
            Integer newScore = intent.getIntExtra("newScore",0);
            TextView score = (TextView) findViewById(R.id.Score);
            score.setText(String.valueOf(newScore));
        }
    }
}
