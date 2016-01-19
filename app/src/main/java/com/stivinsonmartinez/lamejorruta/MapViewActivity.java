package com.stivinsonmartinez.lamejorruta;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapViewActivity extends AppCompatActivity {
    private WebView webView;
    private String ruta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_map_view);

        ruta=getIntent().getExtras().getString("Url");

        webView= (WebView) findViewById(R.id.webview);
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(ruta);
    }
}
