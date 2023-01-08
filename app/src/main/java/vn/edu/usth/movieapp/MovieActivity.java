package vn.edu.usth.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    ImageView movImg;
    TextView movName;
    TextView movDate;
    TextView movRate;
    TextView movDuration;
    TextView strLi;
    TextView dir;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowshowing);

        ImageButton btn = (ImageButton) findViewById(R.id.btnBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieActivity.this, MainActivity.class));
            }
        });

        movImg = findViewById(R.id.movImg);
        movName = findViewById(R.id.movName);
        movDate = findViewById(R.id.movDate);
        movRate = findViewById(R.id.movRate);
        movDuration = findViewById(R.id.movDuration);
        strLi = findViewById(R.id.strLi);
        dir = findViewById(R.id.dir);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            movie = (Movie) intent.getSerializableExtra("item");

            movImg.setImageResource(movie.getImgID());
            movName.setText(movie.getName());
            movDate.setText(movie.getReleaseDate());
            movRate.setText(movie.getRatePG());
            movDuration.setText(movie.getDurationTime());
            strLi.setText(movie.getStoryLine());
            dir.setText(movie.getDirector());

        }

    }
}