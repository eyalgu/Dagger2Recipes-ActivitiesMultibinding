package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by froger_mcs on 09/08/16.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return activity;
    }
}
