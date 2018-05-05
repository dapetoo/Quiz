package com.dapetoo.quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        String quizResult = getIntent().getStringExtra("Quiz_Result");
        TextView thanksView = findViewById(R.id.thanks_view);
        thanksView.setText(R.string.str);
        TextView yourAnswer = findViewById(R.id.your_answer);
        yourAnswer.setText(quizResult);
        TextView quizAnswer = findViewById(R.id.quiz_answer);
        quizAnswer.setText("Yes\nYes\nNo\nYes\nNo");
    }

    public void backToQuiz(View view) {
        Intent viewResult = new Intent(this, MainActivity.class);
        if (viewResult.resolveActivity(getPackageManager()) != null) {
            startActivity(viewResult);
        }
    }

    public void mailQuizResult(View view) {
        EditText editText = findViewById(R.id.editText);
        String editable = editText.getText().toString();
        String quizResult = getIntent().getStringExtra("Quiz_Result");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz Result " + editable);
        intent.putExtra(Intent.EXTRA_TEXT, "Quiz Result taken by " + editable +
                " on the Quiz App developed by Peter. " + "\n" + quizResult);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

