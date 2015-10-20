package com.antonioejemplos.webview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wb=(WebView)findViewById(R.id.webView1);

        //Habilitamos Javascript
        WebSettings config=wb.getSettings();
        config.setJavaScriptEnabled(true);

        // Url que carga la app (webview)
        wb.loadUrl("http://google.com");
        // Forzamos el webview para que abra los enlaces internos dentro de la la APP
        wb.setWebViewClient(new WebViewClient());
        // Forzamos el webview para que abra los enlaces externos en el navegador
        wb.setWebViewClient(new MyAppWebViewClient());


    }

    @Override
// Detectar cuando se presiona el botón de retroceso
    public void onBackPressed() {
        if(wb.canGoBack()) {
            wb.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
