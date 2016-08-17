package com.mac.training.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView mainWebView;
    private EditText searchEdit;
    private Button searchButton;

    private class InternalWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().getHost());
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainWebView = (WebView) findViewById(R.id.mainwebview);
        mainWebView.loadUrl("https://www.google.com");
        mainWebView.getSettings().setJavaScriptEnabled(true);
        mainWebView.setWebViewClient(new InternalWebView());

        searchEdit = (EditText) findViewById(R.id.searchedit);

        searchButton = (Button) findViewById(R.id.searchbutton);
    }
}
