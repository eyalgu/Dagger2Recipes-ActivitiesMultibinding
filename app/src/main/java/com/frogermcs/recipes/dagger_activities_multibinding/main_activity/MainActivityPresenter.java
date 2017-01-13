package com.frogermcs.recipes.dagger_activities_multibinding.main_activity;

import android.app.Activity;

import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 * Created by froger_mcs on 19/09/16.
 */

@ActivityScope
public class MainActivityPresenter {
    private final MainActivity activity;
    private final Utils utils;

    @Inject
    public MainActivityPresenter(Activity activity, Utils utils) {
        this.activity = (MainActivity) activity;
        this.utils = utils;
    }

    public void init() {
        activity.updateText(utils.getHardcodedText());
    }
}
