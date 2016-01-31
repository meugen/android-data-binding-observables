package com.beltranfebrer.databindingobservables;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View room = findViewById(R.id.room);
        final Switch switcher = (Switch) findViewById(R.id.switcher);
        final ImageView light1 = (ImageView) findViewById(R.id.light1);
        final ImageView light2 = (ImageView) findViewById(R.id.light2);
        final ImageView light3 = (ImageView) findViewById(R.id.light3);

        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int color = getResources().getColor(isChecked
                        ? R.color.yellow_on
                        : R.color.yellow_off);
                light1.setColorFilter(color);
                light2.setColorFilter(color);
                light3.setColorFilter(color);
                room.setBackground(new ColorDrawable(getResources()
                        .getColor(isChecked
                                ? R.color.background_material_light
                                : R.color.background_material_dark)));
            }
        });
    }
}
