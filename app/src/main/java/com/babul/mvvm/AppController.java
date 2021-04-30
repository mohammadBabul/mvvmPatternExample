package com.babul.mvvm;
import android.app.Application;
import android.content.ComponentCallbacks;

public class AppController extends Application {

    private static AppController app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static synchronized AppController getInstance() {
        return app;
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }
}

