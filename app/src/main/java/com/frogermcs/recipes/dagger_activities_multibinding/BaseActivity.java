package com.frogermcs.recipes.dagger_activities_multibinding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.FieldsInjector;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityScope;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.HasActivityFieldsInjectors;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponentFactory;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by froger_mcs on 09/08/16.
 */
@ActivityScope
public abstract class BaseActivity extends AppCompatActivity implements HasActivityFieldsInjectors {

    private ActivityComponent mActivityComponent;

    @Inject
    Map<Class<? extends Activity>, Provider<FieldsInjector>> activityInjectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected void setupActivityComponent() {
        mActivityComponent = getActivityComponentFactory()
                .newActivityComponent(this);
        mActivityComponent.inject(this);
        FieldsInjector injector = this.getFieldsInjector(getClass());
        injector.inject(this);
    }

    @Override
    public <T extends Activity> FieldsInjector<T> getFieldsInjector(
            Class<T> activityClass) {
        return activityInjectors.get(activityClass).get();
    }

    private ActivityComponentFactory getActivityComponentFactory() {
        return (ActivityComponentFactory) getApplicationContext();
    }
}
