package com.srmstudios.emaarshahrukhmalik.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.srmstudios.emaarshahrukhmalik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shahrukh Malik on 12/27/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    public abstract int getLayout();
    public abstract Fragment getFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initializeFragment();
    }

    private void initializeFragment(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        if(fragment == null){
            fragment = getFragment();
            manager.beginTransaction()
                    .add(R.id.fragmentContainer,fragment)
                    .commit();
        }
    }

}







