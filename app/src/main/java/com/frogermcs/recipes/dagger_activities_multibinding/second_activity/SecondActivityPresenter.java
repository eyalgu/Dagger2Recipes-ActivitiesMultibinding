package com.frogermcs.recipes.dagger_activities_multibinding.second_activity;

import android.app.Activity;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 * Created by froger_mcs on 16/10/2016.
 */

@ActivityScope
public class SecondActivityPresenter {
    private Activity activity;

    @Inject
    public SecondActivityPresenter(Activity activity) {
        this.activity = activity;
    }
}
