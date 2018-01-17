package com.srmstudios.emaarshahrukhmalik.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.ShiftResponse;

import java.util.List;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class ShiftSpinnerAdapter extends BaseAdapter {
    private List<ShiftResponse> shifts;

    public ShiftSpinnerAdapter(List<ShiftResponse> shifts) {
        this.shifts = shifts;
    }

    @Override
    public int getCount() {
        return shifts.size();
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
        ShiftResponse shift = shifts.get(i);
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_item_shift, null);
        TextView txtShiftName = view.findViewById(R.id.txtShiftName);
        if(shift.getName() != null) {
            txtShiftName.setText(shift.getName());
        }
        return view;
    }
}
