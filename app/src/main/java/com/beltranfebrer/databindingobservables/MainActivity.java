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
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setListeners(this);
        viewModel = new ViewModel();
        binding.setViewModel(viewModel);

    }

    public void onLightChanged(CompoundButton view, boolean isChecked) {
        viewModel.isOn = isChecked;
        binding.setViewModel(viewModel);
    }

    public void onColorChanged(CompoundButton view, boolean isChecked) {
        viewModel.isColor = isChecked;
        binding.setViewModel(viewModel);
    }

    public void onMessageChanged(CompoundButton view, boolean isChecked) {
        viewModel.isChanged = isChecked;
        binding.setViewModel(viewModel);
    }

    public static class ViewModel {
        public boolean isOn;
        public boolean isColor;
        public boolean isChanged;
    }
}
