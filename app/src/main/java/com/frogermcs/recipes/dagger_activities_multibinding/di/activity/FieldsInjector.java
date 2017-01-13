package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import android.app.Activity;

/**
 * Created by eyalg on 1/13/17.
 */

public interface FieldsInjector<T> {
    void inject(T instance);
}
