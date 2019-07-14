package com.hitesh.sentry;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.sentry.Sentry;
import io.sentry.android.AndroidSentryClientFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context ctx = this.getApplicationContext();

        // Use the Sentry DSN (client key) from the Project Settings page on Sentry
        String sentryDsn = "https://8d09d607c899440f9ae29e86e9d6fe21@sentry.io/1227901";
        Sentry.init(sentryDsn, new AndroidSentryClientFactory(ctx));
    }

  void unsafeMethod() {
      throw new UnsupportedOperationException("You shouldn't call this!");
  }
    public void onClickBreak(View view) {
        try{
            unsafeMethod();
        }
        catch (Exception e){
            Sentry.capture(e);
        }
    }

    public void onClickCapture(View view) {
        try {
          unsafeMethod();
        } catch (Exception e) {
            Sentry.capture(e);
        }
    }
}


