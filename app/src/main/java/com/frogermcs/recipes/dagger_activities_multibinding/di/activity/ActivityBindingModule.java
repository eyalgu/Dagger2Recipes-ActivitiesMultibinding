package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import android.app.Activity;

import com.frogermcs.recipes.dagger_activities_multibinding.main_activity.MainActivity;
import com.frogermcs.recipes.dagger_activities_multibinding.second_activity.SecondActivity;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by froger_mcs on 14/09/16.
 */

@Module
public class ActivityBindingModule {

    @Provides
    @IntoMap
    @ActivityKey(MainActivity.class)
    @ActivityScope
    ActivityInjector mainActivityInjector(final MembersInjector<MainActivity> membersInjector) {
        return ActivityInjectors.from(membersInjector);
    }

    @Provides
    @IntoMap
    @ActivityKey(SecondActivity.class)
    @ActivityScope
    ActivityInjector secondActivityInjector(final MembersInjector<SecondActivity> membersInjector) {
        return ActivityInjectors.from(membersInjector);
    }
}