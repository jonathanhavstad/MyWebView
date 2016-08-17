package com.mac.training.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
            view.loadUrl(request.getUrl().getPath());
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

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                sb.append(searchEdit.getText().toString());

                if (sb.indexOf("http") < 0) {
                    sb.insert(0, "http://");
                }

                mainWebView.loadUrl(sb.toString());
            }
        });
    }
}
