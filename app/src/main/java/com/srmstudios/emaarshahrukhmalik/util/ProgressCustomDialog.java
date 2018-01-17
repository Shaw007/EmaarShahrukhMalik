package com.srmstudios.emaarshahrukhmalik.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;

/**
 * Created by Shahrukh Malik on 12/29/2017.
 */

public class ProgressCustomDialog {
    private Dialog dialog;
    private Context context;

    public ProgressCustomDialog(Context context, String message){
        this.context = context;
        this.dialog = new Dialog(context);
        this.dialog.setCancelable(false);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dialog.setContentView(R.layout.layout_dialog_av_loader_with_text);
        ((TextView)dialog.findViewById(R.id.txtMesg)).setText(message);
    }

    public void showDialog(){
        this.dialog.show();
    }

    public void hideDialog(){
        this.dialog.dismiss();
    }
}
