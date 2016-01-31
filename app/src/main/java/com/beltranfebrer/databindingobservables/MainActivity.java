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
        final ImageView light = (ImageView) findViewById(R.id.light);

        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                light.setColorFilter(getResources()
                        .getColor(isChecked
                                        ? R.color.yellow_on
                                        : R.color.yellow_off));
                room.setBackground(new ColorDrawable(getResources()
                        .getColor(isChecked
                                ? R.color.background_material_light
                                : R.color.background_material_dark)));
            }
        });
    }
}
