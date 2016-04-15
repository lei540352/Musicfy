package com.shiva0705.sample.musicfy;

import android.test.ActivityInstrumentationTestCase2;

import com.shiva0705.sample.musicfy.ui.activities.SplashActivity;

import org.junit.Test;

public class SplashActivityTest extends ActivityInstrumentationTestCase2<SplashActivity>{

    public SplashActivityTest() { super(SplashActivity.class);}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
        
    }

    @Test
    public void testSpotifyLogin(){

    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
