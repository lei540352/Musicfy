package com.shiva0705.sample.musicfy.ui.activities.core

import android.app.Activity
import android.content.Intent
import com.shiva0705.sample.musicfy.ui.activities.MainActivity

object ActivityStartupHelper{

    fun startMainActivity(activity: Activity){
        val intent = Intent(activity, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity.startActivity(intent)
        activity.finish()
    }
}