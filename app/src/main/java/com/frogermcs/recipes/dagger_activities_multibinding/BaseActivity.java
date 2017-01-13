package com.frogermcs.recipes.dagger_activities_multibinding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityInjector;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityScope;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.HasMembersInjectors;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponentFactory;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by froger_mcs on 09/08/16.
 */
@ActivityScope
public abstract class BaseActivity extends AppCompatActivity implements HasMembersInjectors {

    private ActivityComponent mActivityComponent;

    @Inject
    Map<Class<? extends Activity>, Provider<ActivityInjector>> activityInjectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected void setupActivityComponent() {
        mActivityComponent = getActivityComponentFactory()
                .newActivityComponent(this);
        mActivityComponent.inject(this);
        ActivityInjector injector = this.getMembersInjector(getClass());
        injector.inject(this);
    }

    @Override
    public ActivityInjector getMembersInjector(Class<? extends Activity> aClass) {
        return activityInjectors.get(aClass).get();
    }

    private ActivityComponentFactory getActivityComponentFactory() {
        return (ActivityComponentFactory) getApplicationContext();
    }
}
