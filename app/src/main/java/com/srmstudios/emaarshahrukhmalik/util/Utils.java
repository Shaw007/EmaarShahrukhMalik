package com.srmstudios.emaarshahrukhmalik.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class Utils {
    private Context context;

    public Utils(Context context){
        this.context = context;
    }

    public String getFormattedDate(Date date, String dateFormat){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            return simpleDateFormat.format(date);
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public long getMillisecondsByAddingMonthsToCurrentTimestamp(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime().getTime();
    }

    public String getStringFromResourceId(int stringResourceId){
        try {
            if(context != null) {
                return context.getResources().getString(stringResourceId);
            }
            else {
                return "";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public boolean isInternetAvailable(){
        if(context != null) {
            try {
                boolean haveConnectedWifi = false;
                boolean haveConnectedMobile = false;
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo[] netInfo = cm.getAllNetworkInfo();
                for (NetworkInfo ni : netInfo) {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected()) {
                            haveConnectedWifi = true;
                        }
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected()) {
                            haveConnectedMobile = true;
                        }
                }
                return haveConnectedWifi || haveConnectedMobile;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
    }
}
