package com.example.guest.localbusiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReviewsActivity extends AppCompatActivity {
    public static final String TAG = ReviewsActivity.class.getSimpleName();

    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        getRestaurants("Portland");
        ButterKnife.bind(this);
    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mRestaurants = yelpService.processResults(response);

                ReviewsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] restaurantNames = new String[mRestaurants.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mRestaurants.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ReviewsActivity.this, android.R.layout.simple_list_item_1, restaurantNames);
                        mListView.setAdapter(adapter);

                        for (Restaurant restaurant : mRestaurants) {
                            Log.d(TAG, "Name: " + restaurant.getName());
                            Log.d(TAG, "Phone: " + restaurant.getPhone());
                            Log.d(TAG, "Website: " + restaurant.getWebsite());
                            Log.d(TAG, "Image url: " + restaurant.getImageUrl());
                            Log.d(TAG, "Rating: " + Double.toString(restaurant.getRating()));
                            Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", restaurant.getAddress()));
                        }
                    }
                });
            }

        });
    }
}
