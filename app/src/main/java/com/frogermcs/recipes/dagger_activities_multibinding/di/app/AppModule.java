package com.frogermcs.recipes.dagger_activities_multibinding.di.app;

import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by froger_mcs on 14/09/16.
 */

@Module(subcomponents = ActivityComponent.class)
public class AppModule {

    public AppModule() {
    }

    @Provides
    @Singleton
    public Utils provideUtils() {
        return new Utils();
    }

}