package com.example.admin.ch8_3;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends DialogFragment {
    static MyDialog newInstance(String title){
        MyDialog dlg = new MyDialog();
        Bundle args = new Bundle();
        args.putString("title" , title);
        dlg.setArguments(args);
        return dlg;
    }

    DialogInterface.OnClickListener p_click = new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialogInterface, int whichButton){

        }
    };

    DialogInterface.OnClickListener n_click = new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialogInterface, int whichButton){

        }
    };

    public Dialog onCreateDialog(Bundle saveInstanceState){ //建立Dialog被呼叫會做的事
        String title = getArguments().getString("title");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage("Close Program?")
                .setPositiveButton("OK", p_click)
                .setNegativeButton("Cancel", n_click);
        return builder.create();
    }


    public MyDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }

}
