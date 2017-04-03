package io.happylrd.childishscorems.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.utils.StaticClass;

public class AdministratorActivity extends AppCompatActivity {
    private WebView mWebView;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, AdministratorActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.loadUrl(StaticClass.ADMIN_MS_URL);
    }
}
