package com.example.guest.localbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.locationsButton) Button mLocationsButton;
    @Bind(R.id.reviewsButton) Button mReviewsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAboutButton.setOnClickListener(this);
        mLocationsButton.setOnClickListener(this);
        mReviewsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAboutButton) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        else if (v == mLocationsButton) {
            Intent intent = new Intent(MainActivity.this, LocationsActivity.class);
            startActivity(intent);
        } else if (v == mReviewsButton) {
            Intent intent = new Intent(MainActivity.this, ReviewsActivity.class);
            startActivity(intent);
        }
    }
}
