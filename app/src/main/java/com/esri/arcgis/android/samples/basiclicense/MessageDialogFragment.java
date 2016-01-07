package com.esri.arcgis.android.samples.basiclicense;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/**
 * Created by kobexuqiang on 2016/1/7.
 */
public class MessageDialogFragment extends DialogFragment{
    public static final String TAG = MessageDialogFragment.class.getSimpleName();
    private final static String KEY_ARG_DIALOG_MESSAGE = "KEY_ARG_DIALOG_MESSAGE";
    public static void showMessage(String message,FragmentManager fragmentManager)
    {
        MessageDialogFragment dialog = newInstance(message);
        dialog.show(fragmentManager,TAG);
    }
    private static MessageDialogFragment newInstance(String message)
    {
        MessageDialogFragment dialog = new MessageDialogFragment();
        Bundle args = new Bundle();
        args.putString(KEY_ARG_DIALOG_MESSAGE, message);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE,STYLE_NORMAL);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String message = null;
        Bundle args = getArguments();
        if(args != null)
        {
            message = args.getString(KEY_ARG_DIALOG_MESSAGE);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
