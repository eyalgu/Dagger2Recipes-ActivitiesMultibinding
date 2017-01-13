package com.frogermcs.recipes.dagger_activities_multibinding.di.activity;

import dagger.MembersInjector;

/**
 * Created by eyalg on 1/13/17.
 */

public class FieldsInjectors {

    public static <T> FieldsInjector<T> from(MembersInjector<T> membersInjector) {
        return new MembersInjectorConverter<T>(membersInjector);
    }

    private static class MembersInjectorConverter<T> implements FieldsInjector<T> {
        private final MembersInjector<T> mDelegate;

        private MembersInjectorConverter(MembersInjector<T> delegate) {
            mDelegate = delegate;
        }

        @Override
        public void inject(T activity) {
            mDelegate.injectMembers(activity);
        }
    }
}
