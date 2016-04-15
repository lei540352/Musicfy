package com.shiva0705.sample.musicfy;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import com.shiva0705.sample.musicfy.domain.GameConfig;
import com.shiva0705.sample.musicfy.ui.activities.MainActivity;

import org.junit.Test;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    public MainActivityTest() { super(MainActivity.class);}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Test
    public void testNextBtn(){

        for(String g : GameConfig.INSTANCE.getGame_genres()) {
            sleep10();
            Espresso.onView(ViewMatchers.withId(R.id.btn_next)).perform(ViewActions.click());
        }

        Espresso.onView(ViewMatchers.withId(R.id.score)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private void sleep10() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
    }
}
