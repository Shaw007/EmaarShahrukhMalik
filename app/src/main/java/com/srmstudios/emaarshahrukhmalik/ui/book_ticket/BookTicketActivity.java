package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.ui.BaseActivity;

public class BookTicketActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_base;
    }

    @Override
    public Fragment getFragment() {
        return new BookTicketFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
