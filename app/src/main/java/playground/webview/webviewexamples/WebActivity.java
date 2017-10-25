package playground.webview.webviewexamples;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.json.JSONObject;

public class WebActivity extends AppCompatActivity {
String html;
    String url;
    private static final String TAG = "WebActivity";
    WebView customerPageView;
    String savedData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            html = extras.getString("html");

        }

        customerPageView = (WebView) findViewById(R.id.webview);
        customerPageView.clearCache(true);
        customerPageView.getSettings().setAppCacheEnabled(false);
        customerPageView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        customerPageView.getSettings().setJavaScriptEnabled(true);
        customerPageView.addJavascriptInterface(new WebAppInterface(this), "Android");
        startWebView(url);
       /* */

        clearCookies(this);
    }

    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link

        customerPageView.setWebViewClient(new WebViewClient() {

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // view.loadUrl(url);


                return true;
            }





            //Show loader on url load
            public void onLoadResource (WebView view, String url) {

            }
            public void onPageFinished(WebView view, String url) {

            }



        });

        // Javascript inabled on webview



        //Load url in webview
        // customerPageView.loadUrl(url);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";



        customerPageView.loadDataWithBaseURL("", html, mimeType, encoding, "");



    }

    public static void clearCookies(Context context)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            Log.d(TAG, "Using clearCookies code for API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else
        {
            Log.d(TAG, "Using clearCookies code for API <" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieSyncManager cookieSyncMngr=CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager=CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show Toast Message
         * @param toast
         */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }


        @JavascriptInterface
        public void setAnswers(){

            customerPageView.post(new Runnable() {
                @Override
                public void run() {

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        customerPageView.evaluateJavascript("setAnswers("+savedData+")", null);
                    } else {
                        customerPageView.loadUrl("javascript:setAnswers("+savedData+")");
                    }


                   // customerPageView.loadUrl("javascript:setAnswers("+savedData+")");
                }
            });
           // customerPageView.loadUrl("javascript:setAnswers('"+savedData+")'");
            Toast.makeText(mContext, "called setanswers", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void saveData(String data) {
           savedData = data;
            Toast.makeText(mContext, "Done", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void showToast() {
            Toast.makeText(mContext, "simple toast", Toast.LENGTH_SHORT).show();
        }

        /**
         * Show Dialog
         * @param dialogMsg
         */
        @JavascriptInterface
        public void showDialog(String dialogMsg){
            AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

            // Setting Dialog Title
            alertDialog.setTitle("JS triggered Dialog");

            // Setting Dialog Message
            alertDialog.setMessage(dialogMsg);

            // Setting alert dialog icon
            //alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(mContext, "Dialog dismissed!", Toast.LENGTH_SHORT).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

        /**
         * Intent - Move to next screen
         */
        @JavascriptInterface
        public void moveToNextScreen(){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            // Setting Dialog Title
            alertDialog.setTitle("Alert");
            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to leave ?");
            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Move to Next screen
                            Intent chnIntent = new Intent(WebActivity.this, MainActivity.class);
                            startActivity(chnIntent);
                        }
                    });
            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Cancel Dialog
                            dialog.cancel();
                        }
                    });
            // Showing Alert Message
            alertDialog.show();
        }
    }

    @JavascriptInterface           // For API 17+
    public void performClick(String strl)
    {
        Toast.makeText (WebActivity.this, strl, Toast.LENGTH_SHORT).show();

    }

    @JavascriptInterface
    public void onButtonClicked(){

        Toast.makeText(this, "onbuttoncliked triggered", Toast.LENGTH_SHORT).show();
    }

}
