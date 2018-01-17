package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.srmstudios.emaarshahrukhmalik.R;

import java.util.Calendar;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private DateSelectedListener dateSelectedListener;
    private int selectedYear,selectedMonth,selectedDay; // these are used to show the old date which the user selected first time
    private long millisecondsOfTwoMonthFromNow;

    public DatePickerFragment(){

    }

    @SuppressLint("ValidFragment")
    public DatePickerFragment(DateSelectedListener dateSelectedListener,int selectedYear,int selectedMonth,int selectedDay,long millisecondsOfTwoMonthFromNow){
        this.dateSelectedListener = dateSelectedListener;
        this.selectedYear = selectedYear;
        this.selectedMonth = selectedMonth;
        this.selectedDay = selectedDay;
        this.millisecondsOfTwoMonthFromNow = millisecondsOfTwoMonthFromNow;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        if( (selectedYear == 0) && (selectedMonth == 0) && (selectedDay == 0) ){
            // current time by default
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int dayOnMonth = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.DatePickerDialogTheme,this,year,month,dayOnMonth);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.getDatePicker().setMaxDate(millisecondsOfTwoMonthFromNow);
            return datePickerDialog;
        }else {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),R.style.DatePickerDialogTheme,this,selectedYear,selectedMonth,selectedDay);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.getDatePicker().setMaxDate(millisecondsOfTwoMonthFromNow);
            return datePickerDialog;
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        this.dateSelectedListener.onDateSelected(datePicker,year,monthOfYear,dayOfMonth);
    }

    public interface DateSelectedListener {
        void onDateSelected(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth);
    }

}

