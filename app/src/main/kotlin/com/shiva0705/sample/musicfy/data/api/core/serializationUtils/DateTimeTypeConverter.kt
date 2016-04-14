package com.shiva0705.sample.sampleApp.data.api.core.serializationUtils

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer

import org.joda.time.DateTime

import java.lang.reflect.Type

class DateTimeTypeConverter : JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
    // No need for an InstanceCreator since DateTime provides a no-args constructor
    override fun serialize(src: DateTime, srcType: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src.toString())
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): DateTime {
        return DateTime(json.asString)
    }
}	
