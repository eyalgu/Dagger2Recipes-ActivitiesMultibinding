package com.frogermcs.recipes.dagger_activities_multibinding;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityModule;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.HasActivityFieldsInjectors;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponentFactory;
import com.frogermcs.recipes.dagger_activities_multibinding.di.app.AppComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.app.DaggerAppComponent;

/**
 * Created by froger_mcs on 14/09/16.
 */

public class MyApplication extends Application implements ActivityComponentFactory {

    private AppComponent appComponent;

    public static HasActivityFieldsInjectors get(Context context) {
        return ((HasActivityFieldsInjectors) context.getApplicationContext());
    }

    @Override
    public ActivityComponent newActivityComponent(Activity activity) {
        return appComponent.activityComponentBuilder()
                .activityModule(new ActivityModule(activity))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

}