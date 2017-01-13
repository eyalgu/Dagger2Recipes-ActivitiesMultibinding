package com.frogermcs.recipes.dagger_activities_multibinding;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityModule;
import com.frogermcs.recipes.dagger_activities_multibinding.main_activity.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


/**
 * Created by froger_mcs on 17/10/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Mock
    ActivityComponent.Builder builder;
    @Mock
    Utils utilsMock;

    private ActivityComponent mainActivityComponent = new ActivityComponent() {
        @Override
        public void inject(BaseActivity instance) {
//            instance.activityInjectors = new HashMa
        }
    };

    @Before
    public void setUp() {
        when(builder.build()).thenReturn(mainActivityComponent);
        when(builder.activityModule(any(ActivityModule.class))).thenReturn(builder);

        MyApplication app = (MyApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
//        app.putActivityComponentBuilder(builder, MainActivity.class);
    }

    @Test
    public void checkTextView() {
        String expectedText = "lorem ipsum";
        when(utilsMock.getHardcodedText()).thenReturn(expectedText);

        activityRule.launchActivity(new Intent());

        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }

}