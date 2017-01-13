package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

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
    FieldsInjector mainActivityInjector(final MembersInjector<MainActivity> membersInjector) {
        return FieldsInjectors.from(membersInjector);
    }

    @Provides
    @IntoMap
    @ActivityKey(SecondActivity.class)
    @ActivityScope
    FieldsInjector secondActivityInjector(final MembersInjector<SecondActivity> membersInjector) {
        return FieldsInjectors.from(membersInjector);
    }
}