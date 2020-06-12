package com.pram.bookdatabaserealm;

import android.app.Application;

import com.pram.bookdatabaserealm.manager.Contextor;

import io.realm.Realm;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
        Realm.init(getApplicationContext()); // todo 3. add this line
    }
}
