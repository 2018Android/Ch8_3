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
    //Dialog "確定"按鈕被點擊須執行的動作監聽物件
    DialogInterface.OnClickListener p_click = new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialogInterface, int whichButton){
            ((MainActivity)getActivity()).btn_frag1_do_P_Click();  //getActivity()強制轉換(MainActivity)成物件
        }
    };
    //Dialog "取消"按鈕被點擊須執行的動作監聽物件
    DialogInterface.OnClickListener n_click = new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialogInterface, int whichButton){
            ((MainActivity)getActivity()).btn_frag1_do_N_Click(); //getActivity()強制轉換(MainActivity)成物件
        }
    };
    //Dialog物件生成當下需執行的動作→Dialog被呼叫會做的事
    public Dialog onCreateDialog(Bundle saveInstanceState){
        String title = getArguments().getString("title");                                          //取得參數title
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());                    //建立dialog原生物件
        builder.setTitle(title)                                                                   //設定title
                .setMessage("確認結束本程式?")                                                   //設定內文訊息
                .setPositiveButton("確定", p_click)                                               //設定確定按鈕
                .setNegativeButton("取消", n_click);                                              //設定取消按鈕
        return builder.create();                                                                   //建立dialog
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
