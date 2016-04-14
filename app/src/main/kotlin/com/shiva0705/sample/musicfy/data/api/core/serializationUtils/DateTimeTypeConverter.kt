package com.shiva0705.sample.musicfy.data.api.core.serializationUtils

import com.google.gson.*
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
