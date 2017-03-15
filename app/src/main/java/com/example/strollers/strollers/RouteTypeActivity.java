package com.example.strollers.strollers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RouteTypeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_type);

        Button button = (Button) findViewById(R.id.distance);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.calorie);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), RouteOptionsActivity.class);
        switch (v.getId()) {
            case R.id.distance:
                intent.putExtra(Constants.ROUTE_PROMPT, R.string.distance_prompt);
                intent.putExtra(Constants.ROUTE_UNIT, R.string.distance_unit);
                break;
            case R.id.calorie:
                intent.putExtra(Constants.ROUTE_PROMPT, R.string.calorie_prompt);
                intent.putExtra(Constants.ROUTE_UNIT, R.string.calorie_unit);
                break;
        }

        startActivity(intent);
    }
}
