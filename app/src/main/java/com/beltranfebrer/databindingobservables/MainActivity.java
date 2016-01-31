package com.beltranfebrer.databindingobservables;

import android.annotation.TargetApi;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
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
        viewModel.isOn.set(isChecked);
    }

    public void onColorChanged(CompoundButton view, boolean isChecked) {
        viewModel.isColor.set(isChecked);
    }

    public void onMessageChanged(CompoundButton view, boolean isChecked) {
        viewModel.isChanged.set(isChecked);
    }

    public static class ViewModel extends BaseObservable {
        @Bindable
        public final ObservableBoolean isOn = new ObservableBoolean();
        @Bindable
        public final ObservableBoolean isColor = new ObservableBoolean();
        @Bindable
        public final ObservableBoolean isChanged = new ObservableBoolean();
    }
}
