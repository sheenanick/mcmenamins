package com.example.guest.localbusiness.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.localbusiness.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.reviewsButton) Button mReviewsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAboutButton.setOnClickListener(this);
        mReviewsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAboutButton) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (v == mReviewsButton) {
            Intent intent = new Intent(MainActivity.this, ReviewsActivity.class);
            startActivity(intent);
        }
    }
}
