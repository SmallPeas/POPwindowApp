package com.example.rr.popwindowapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.button1:
              Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
              Setpop();    break;
          case R.id.TView1:
              Toast.makeText(MainActivity.this,"选项一",Toast.LENGTH_SHORT).show(); break;
          case R.id.TView2:
              Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();   break;
      }
    }
    private void Setpop(){
        View view = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.activity_pop,null);
        PopupWindow mWin=new PopupWindow();
        mWin.setContentView(view);
        mWin.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWin.setHeight(FrameLayout.LayoutParams.WRAP_CONTENT);
        TextView text1= (TextView) view.findViewById(R.id.TView1);//获取view里的TextV的id；
        TextView text2= (TextView) view.findViewById(R.id.TView2);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        //-----显示位置
//        View rootView=LayoutInflater.from(MainActivity.this)//显示PopupWindow的显示位置
//                .inflate(R.layout.activity_main,null);
//        mWin.showAtLocation(rootView,Gravity.BOTTOM,0,0);//位置为底部-----//
        mWin.showAsDropDown(mButton);//使PopupWindow显示在Button的底部
    }
}
