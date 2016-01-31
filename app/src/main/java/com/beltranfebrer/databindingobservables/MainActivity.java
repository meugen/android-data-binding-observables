package com.beltranfebrer.databindingobservables;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.beltranfebrer.databindingobservables.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setListeners(this);
    }

    public void onLightChanged(CompoundButton view, boolean isChecked) {
        binding.setIsOn(isChecked);
    }

    public void onColorChanged(CompoundButton view, boolean isChecked) {
        binding.setIsColor(isChecked);
    }

    public void onMessageChanged(CompoundButton view, boolean isChecked) {
        binding.setIsChanged(isChecked);
    }
}
