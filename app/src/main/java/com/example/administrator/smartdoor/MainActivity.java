package com.example.administrator.smartdoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

 //   Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void connect(View v)
    {
        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

        //获取编辑框的IP地址
        EditText editText = findViewById(R.id.editText);
        String val = editText.getText().toString();

        //获得编辑器的端口号
        EditText editText1 = findViewById(R.id.editText1);
        String val1 = editText1.getText().toString();

        //跳转到界面2
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("val",val);
        intent.putExtra("val1",val1);
        startActivityForResult(intent,0x01);

    }

    public void quit(View v)
    {
        Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
        System.exit(0);
    }

}
