package com.srmstudios.emaarshahrukhmalik.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderResponse;
import com.srmstudios.emaarshahrukhmalik.data.model.response.ShiftResponse;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class GenderSpinnerAdapter extends BaseAdapter {
    private List<GenderResponse> genders;
    private LayoutInflater inflater;

    public GenderSpinnerAdapter(List<GenderResponse> genders) {
        this.genders = genders;
    }

    @Override
    public int getCount() {
        return genders.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GenderResponse gender = genders.get(i);
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_item_gender, null);
        TextView txtShiftName = view.findViewById(R.id.txtShiftName);
        if(gender.getDescription() != null) {
            txtShiftName.setText(gender.getDescription());
        }
        return view;
    }
}










