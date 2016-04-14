package com.shiva0705.sample.musicfy.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.shiva0705.sample.musicfy.BuildConfig
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.sampleApp.activities.core.ActivityStartupHelper
import com.shiva0705.sample.musicfy.ui.activities.core.BaseActivity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.spotify.sdk.android.authentication.AuthenticationResponse.Type.TOKEN

class SplashActivity : BaseActivity() {

    val REQUEST_CODE = 1337
    val REDIRECT_URI = "musicfy://home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //openSpotifyLogin()
        Handler().postDelayed({ ActivityStartupHelper.startMainActivity(this) }, 500)
    }

    fun openSpotifyLogin(){
        val builder = AuthenticationRequest.Builder(BuildConfig.SPOTIFY_CLIENT_ID, TOKEN, REDIRECT_URI);

        builder.setScopes(Array(1, {"streaming"}))
        var request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            var response = AuthenticationClient.getResponse(resultCode, intent)

            when(response.type){

                TOKEN -> handleSpotifyLoginSuccess(response)
                //else -> openSpotifyLogin()
            }

        }
    }

    fun handleSpotifyLoginSuccess(response : AuthenticationResponse){
        ActivityStartupHelper.startMainActivity(this)
    }
}
