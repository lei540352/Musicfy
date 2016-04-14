package com.shiva0705.sample.musicfy.data.preferences.core

import android.content.SharedPreferences
import android.text.TextUtils
import com.shiva0705.sample.musicfy.data.api.core.serializationUtils.CustomGsonBuilder
import javax.inject.Inject

abstract class BasePreference() {

    @Inject lateinit var preferences : SharedPreferences

    /*** @param prefName : Name under which preference should be saved
     * @param obj : Generic object that will be serialized and saved**/
    protected fun commit(prefName: String, obj: Any) {
        val editor = preferences.edit()

        editor.putString(prefName, CustomGsonBuilder.build().toJson(obj))
        editor.apply()
    }

    /**
     * @return deserialize saved generic object and return. If it does not exist return null**/
    protected fun <T> read(prefName: String, type: Class<T>): T? {

        val json = preferences.getString(prefName, null)
        var result: Any? = null
        if (!TextUtils.isEmpty(json)) result = CustomGsonBuilder.build().fromJson(json, type)
        return result as T?
    }


}