package com.example.administrator.smartdoor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //得到IP和端口号
        Intent intent = getIntent();
        String ip_addr = intent.getStringExtra("val");
        String port = intent.getStringExtra("val1");
        Toast.makeText(Main2Activity.this, ip_addr+" port"+port, Toast.LENGTH_SHORT).show();

        Init(ip_addr, port);
        //socket函数，返回一个与服务器连接的对象
        //发送的方法
    }

        public void Init(String ip_addr,String port){

            myWebView = (WebView) findViewById(R.id.WebView);//获取view

            WebSettings WebSet = myWebView.getSettings();    //获取webview设置
            WebSet.setJavaScriptEnabled(true);              //设置JavaScript支持

            WebSet.setSupportZoom(true);            // 设置可以支持缩放

            WebSet.setBuiltInZoomControls(true);    // 设置出现缩放工具

            WebSet.setUseWideViewPort(true);        //扩大比例的缩放

            WebSet.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);   //自适应屏幕
            WebSet.setLoadWithOverviewMode(true);

            myWebView.loadUrl("http://"+ip_addr+":"+port+"/?action=stream");

            //开启socket编程，获取服务端连接的对象

            //myWebView.loadUrl("http://www.baidu.com/");
            //设置webview打开的链接

            myWebView.setWebViewClient(new WebViewClient(){  //设置不适用第三方浏览器打开网页
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });
        }

    @Override
    public void onBackPressed() {

        if (myWebView.canGoBack()) {
            myWebView.goBack();//返回上一页面
        } else {
            System.exit(0);//退出程序
        }
    }

}
