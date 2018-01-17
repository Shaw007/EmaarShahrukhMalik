package com.srmstudios.emaarshahrukhmalik.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderResponse;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class AgeSpinnerAdapter extends BaseAdapter{
    private List<Integer> ages;
    private LayoutInflater inflater;

    public AgeSpinnerAdapter(List<Integer> ages) {
        this.ages = ages;
    }

    @Override
    public int getCount() {
        return ages.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_item_gender, null);
        TextView txtShiftName = view.findViewById(R.id.txtShiftName);
        txtShiftName.setText(String.valueOf(ages.get(i)));
        return view;
    }
}




