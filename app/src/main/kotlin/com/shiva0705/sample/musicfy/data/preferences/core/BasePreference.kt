package com.shiva0705.sample.musicfy.data.preferences.core

import android.content.SharedPreferences
import android.text.TextUtils
import com.shiva0705.sample.musicfy.data.api.core.serializationUtils.CustomGsonBuilder
import java.util.*
import javax.inject.Inject

abstract class BasePreference() {

    @Inject lateinit var preferences: SharedPreferences

    /*** @param prefName : Name under which preference should be saved
     * @param obj : Generic object that will be serialized and saved**/
    protected fun commit(prefName: String, obj: Any) {
        val editor = preferences.edit()

        editor.putString(prefName, CustomGsonBuilder.build().toJson(obj))
        editor.apply()
    }

    protected fun <T> commit(preference: String, lst: List<T>?) {
        val editor = preferences.edit()
        val prefName = preference.toString()

        val json = CustomGsonBuilder.build().toJson(lst)
        editor.putString(prefName, json)
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


    protected fun <T> readList(prefName: String, clazz: Class<Array<T>>): List<T>? {

        val json = preferences.getString(prefName, null)

        if (TextUtils.isEmpty(json)) return null

        val arr = CustomGsonBuilder.build().fromJson<Array<T>>(json, clazz)
        return LinkedList(Arrays.asList<T>(*arr))

    }


}