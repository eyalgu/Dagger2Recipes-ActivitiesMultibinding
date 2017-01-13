package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import com.frogermcs.recipes.dagger_activities_multibinding.BaseActivity;

import dagger.Subcomponent;

/**
 * Created by froger_mcs on 16/10/2016.
 */

@ActivityScope
@Subcomponent(modules = {
        ActivityModule.class,
        ActivityBindingModule.class,
})
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);

    @Subcomponent.Builder
    interface Builder {
        Builder activityModule(ActivityModule activityModule);
        ActivityComponent build();
    }
}
