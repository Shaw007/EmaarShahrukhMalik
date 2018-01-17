package com.srmstudios.emaarshahrukhmalik.ui.book_ticket;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.srmstudios.emaarshahrukhmalik.App;
import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.util.AppConstants;
import com.srmstudios.emaarshahrukhmalik.util.ProgressCustomDialog;
import com.srmstudios.emaarshahrukhmalik.util.Utils;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookTicketFragment extends Fragment implements BookTicketMVP.View,View.OnClickListener,DatePickerFragment.DateSelectedListener{
    @BindView(R.id.txtDate)
    protected TextView txtDate;
    @BindView(R.id.relativeDate)
    protected RelativeLayout relativeDate;
    @BindView(R.id.spinnerShifts)
    protected Spinner spinnerShifts;
    @BindView(R.id.recyclerViewVisitorTypes)
    protected RecyclerView recyclerViewVisitorTypes;
    @BindView(R.id.btnBookNow)
    protected Button btnBookNow;
    @BindView(R.id.cardViewParent)
    protected CardView cardViewParent;

    @Inject
    protected Utils utils;
    @Inject
    protected BookTicketMVP.Presenter presenter;

    private Dialog dialog;
    private ProgressCustomDialog progressCustomDialogFetchData;

    // these are used to show the old date which the user selected first time
    private int selectedYear = 0,selectedMonth = 0,selectedDay = 0;

    public BookTicketFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_ticket, container, false);

        initializeViews(v);

        return v;
    }

    private void initializeViews(View v){
        ButterKnife.bind(this,v);
        progressCustomDialogFetchData = new ProgressCustomDialog(getActivity(),
                utils.getStringFromResourceId(R.string.fetching_tickets_info));
        recyclerViewVisitorTypes.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewVisitorTypes.setNestedScrollingEnabled(false);
        relativeDate.setOnClickListener(this);
        btnBookNow.setOnClickListener(this);
        setDateText(Calendar.getInstance());

        if(utils.isInternetAvailable()) {
            showProgressDailogFetchInfo();
            presenter.fetchDataFromAPIs();
        }else {
            showErrorWithRetryDialog(utils.getStringFromResourceId(R.string.no_internet),
                    utils.getStringFromResourceId(R.string.please_check_your_internet_connection));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.relativeDate:{
                DialogFragment datePickerFragment = new DatePickerFragment(this,
                        selectedYear,
                        selectedMonth,
                        selectedDay,
                        utils.getMillisecondsByAddingMonthsToCurrentTimestamp(2));
                datePickerFragment.show(getActivity().getSupportFragmentManager(), "DatePickerDialog");
                break;
            }
            case R.id.btnBookNow:{
                presenter.onClickBtnBookNow();
                break;
            }
        }
    }

    @Override
    public void onDateSelected(DatePicker datePicker,final int year, final int monthOfYear,final int dayOfMonth) {
        if(!((selectedDay == dayOfMonth) && (selectedMonth == monthOfYear) && (selectedYear == year))){
            // this means user has changed the date from date dialog
            if(presenter.isTicketRowAdded()) { // if user has added a ticket row in any visitor type
                // show dialog
                dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.pop_up_confirmation);
                ((TextView)dialog.findViewById(R.id.txtTitle)).setText(utils.getStringFromResourceId(R.string.continue_with_question));
                ((TextView)dialog.findViewById(R.id.txtMessage)).setText(utils.getStringFromResourceId(R.string.all_ticket_would_be_lost));
                (dialog.findViewById(R.id.btnContinue)).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if(utils.isInternetAvailable()) {
                            dialog.dismiss();
                            updateDate(dayOfMonth,monthOfYear,year);
                            showProgressDailogFetchInfo();
                            presenter.getVisitorTypes();
                        }
                    }
                });
                (dialog.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }else {
                updateDate(dayOfMonth,monthOfYear,year);
            }
        }else {
            updateDate(dayOfMonth,monthOfYear,year);
        }
    }

    private void updateDate(int day,int month,int year){
        selectedDay = day;
        selectedMonth = month;
        selectedYear = year;
        Calendar calendar = Calendar.getInstance();
        calendar.set(selectedYear,selectedMonth,selectedDay);
        long minMilliseconds = System.currentTimeMillis() - 1000;
        long selectedMilliseconds = calendar.getTime().getTime();
        if(selectedMilliseconds > minMilliseconds) { // double check on selected date, must not be less than current date
            setDateText(calendar);
        }
    }

    private void setDateText(Calendar calendar){
        txtDate.setText(utils.getFormattedDate(calendar.getTime(),AppConstants.DATE_FORMAT_ONE));
        // this means its first time date is being set, so we initialize these variables to current date
        // these variables are used to check if user changed the date from date dialog
        if((selectedDay == 0) && (selectedMonth == 0) && (selectedYear == 0)){
            selectedDay = calendar.get(Calendar.DAY_OF_MONTH);
            selectedMonth = calendar.get(Calendar.MONTH);
            selectedYear = calendar.get(Calendar.YEAR);
        }
    }

    @Override
    public RecyclerView getRecyclerViewVisitorTypes() {
        return recyclerViewVisitorTypes;
    }

    @Override
    public Spinner getSpinnerShifts() {
        return spinnerShifts;
    }

    @Override
    public void showPopUp(String title, String message) {
        showErrorDialog(title,message);
    }

    @Override
    public void showErrorWithRetryPopUp(String title, String message) {
        showErrorWithRetryDialog(title,message);
    }

    @Override
    public void showWebviewPopup(String title, String htmlContent) {
        showWebViewDialog(title,htmlContent);
    }

    @Override
    public void showProgressDailogFetchInfo() {
        progressCustomDialogFetchData.showDialog();
    }

    @Override
    public void hideProgressDailogFetchInfo() {
        progressCustomDialogFetchData.hideDialog();
    }

    @Override
    public void showCardViewLayout() {
        cardViewParent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCardViewLayout() {
        cardViewParent.setVisibility(View.GONE);
    }

    private void showErrorDialog(String title,String message){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_error);

        ((TextView)dialog.findViewById(R.id.txtTitle)).setText(title);
        ((TextView)dialog.findViewById(R.id.txtMessage)).setText(message);

        (dialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showErrorWithRetryDialog(String title,String message){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_error_with_retry);

        ((TextView)dialog.findViewById(R.id.txtTitle)).setText(title);
        ((TextView)dialog.findViewById(R.id.txtMessage)).setText(message);

        (dialog.findViewById(R.id.btnRetry)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(utils.isInternetAvailable()) {
                    dialog.dismiss();
                    showProgressDailogFetchInfo();
                    presenter.fetchDataFromAPIs();
                }
            }
        });

        (dialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().finish();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showWebViewDialog(String title,String html){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_webview);

        ((TextView)dialog.findViewById(R.id.txtTitle)).setText(title);
        WebView webView = dialog.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(html, "text/html", "UTF-8");

        (dialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}




















