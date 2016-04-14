package com.shiva0705.sample.musicfy.data.api.core.serializationUtils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shiva0705.sample.musicfy.data.api.core.serializationUtils.DateTimeTypeConverter
import org.joda.time.DateTime

object CustomGsonBuilder {
    fun build(): Gson {
        val builder = GsonBuilder()
        builder.registerTypeAdapter(DateTime::class.java, DateTimeTypeConverter())
        return builder.create()

    }
}
