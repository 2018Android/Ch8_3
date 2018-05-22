package com.example.admin.ch8_3;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */

/*
interface EditNameDialogListener{
    void onFinishEditDialog(String inputText);
}
MainActivity就不需要
public void onFinishEditDialog(String inputText){
        Toast.makeText(this, "您好,"+inputText, Toast.LENGTH_SHORT).show();
}
*/

public class EditNameDialog extends DialogFragment {
    private EditText edt_name;
    //定義一個介面"EditNameDialogListener" 包含 "onFinishEditDialog"方法
    public interface EditNameDialogListener{
        void onFinishEditDialog(String inputText);
    }


    public EditNameDialog() {
        // Required empty public constructor
    }

    View.OnClickListener btn_OK_click = new View.OnClickListener(){
      public void onClick(View v){
          EditNameDialogListener activity = (EditNameDialogListener)getActivity();
          //MainActivity activity = (MainActivity)getActivity();
          activity.onFinishEditDialog(edt_name.getText().toString());
          EditNameDialog.this.dismiss();
      }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_name_dialog, container, false);
        getDialog().setTitle("請輸入姓名");
        edt_name = (EditText)view.findViewById(R.id.edt_name);
        edt_name.requestFocus();
        Button btn_OK = (Button)view.findViewById(R.id.btn_ok);
        btn_OK.setOnClickListener(btn_OK_click);
        return view;
    }

}
