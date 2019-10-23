package cn.pres.cf.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Dora
 * @date 2019/10/23 13:14
 **/
public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    /**
     * 线程安全的日期格式化
     *
     * @author dora
     * @return
     * @date 2019/10/23
     **/
    ThreadLocal<DateTimeFormatter> threadLocal = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null == jsonElement ? null : LocalDate.parse(jsonElement.getAsString(), threadLocal.get());
    }

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return null == localDate ? null : new JsonPrimitive(threadLocal.get().format(localDate));
    }
}
