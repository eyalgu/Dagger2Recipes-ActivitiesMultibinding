package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import android.app.Activity;

import dagger.MembersInjector;

/**
 * Created by eyalg on 1/13/17.
 */

public class ActivityInjectors {

    public static ActivityInjector from(MembersInjector<? extends Activity> membersInjector) {
        return new MembersInjectorConverter(membersInjector);
    }

    private static class MembersInjectorConverter implements ActivityInjector {
        private final MembersInjector mDelegate;

        private MembersInjectorConverter(MembersInjector delegate) {
            mDelegate = delegate;
        }

        @Override
        public void inject(Activity activity) {
            mDelegate.injectMembers(activity);
        }
    }
}
