package io.happylrd.childishscorems.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class GsonUTCDateAdapter implements JsonSerializer<Date> {

    private final DateFormat dateFormat;

    public GsonUTCDateAdapter() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(dateFormat.format(src));
    }
}
