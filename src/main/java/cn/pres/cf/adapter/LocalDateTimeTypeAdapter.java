package cn.pres.cf.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dora
 * @date 2019/10/23 13:25
 **/
public class LocalDateTimeTypeAdapter implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {
    ThreadLocal<DateTimeFormatter> threadLocal = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));

    @Override
    public LocalDateTime deserialize(@NotNull JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null == jsonElement ? null : LocalDateTime.parse(jsonElement.getAsString(), threadLocal.get());

    }

    @Override
    public JsonElement serialize(@NotNull LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return null == localDateTime ? null : new JsonPrimitive(threadLocal.get().format(localDateTime));
    }
}
