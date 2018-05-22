package com.example.admin.ch8_3;

import android.app.Dialog;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EditNameDialog.EditNameDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //將btn_fragment1的按鈕綁上監聽物件 btn_fragment1_Click
        Button btn_fragment1 = (Button)findViewById(R.id.btn_fragment1);
        btn_fragment1.setOnClickListener(btn_fragment1_Click);
        //將btn_editname的按鈕綁上監聽物件 btn_EditName_Click
        Button btn_editname = (Button)findViewById(R.id.btn_editname);
        btn_editname.setOnClickListener(btn_EditName_Click);
    }
    //-------MyDialog
    //設定主畫面btn_fragment1的按鈕點擊監聽事件
    View.OnClickListener btn_fragment1_Click = new View.OnClickListener(){
        public  void  onClick(View v){
            MyDialog dlg = MyDialog.newInstance("確認");
            FragmentManager fm = getSupportFragmentManager();
            dlg.show(fm , "dialog");
        }
    };

    //MyDialog 按下確定鈕執行的事
    public void btn_frag1_do_P_Click(){
        Toast.makeText(this, "按下確定鈕", Toast.LENGTH_SHORT).show();
        finish();
    }
    //MyDialog 按下取消鈕執行的事
    public void btn_frag1_do_N_Click(){
        Toast.makeText(this, "按下取消鈕", Toast.LENGTH_SHORT).show();
        finish();
    }

    //------EditNameDialog
    public void onFinishEditDialog(String inputText){
        Toast.makeText(this, "您好,"+inputText, Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener btn_EditName_Click = new View.OnClickListener(){
        public  void  onClick(View v){
            EditNameDialog dlg = new EditNameDialog();
            FragmentManager fm = getSupportFragmentManager();
            dlg.show(fm , "EditNameDialog");
        }
    };
}
