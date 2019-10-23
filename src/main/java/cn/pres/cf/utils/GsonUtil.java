package cn.pres.cf.utils;

import cn.pres.cf.adapter.LocalDateTimeTypeAdapter;
import cn.pres.cf.adapter.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dora
 * @date 2019/10/23 9:19
 **/
@Slf4j
public class GsonUtil {
  private  static  Gson gson = new GsonBuilder()
          .serializeNulls()
          .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
          .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeTypeAdapter())
          .setDateFormat("yyyy-MM-dd hh:mm:ss")
          .create();
  static {

  }
    /**
     * 对象转json
     * @author dora 
     * @return   
     * @date 2019/10/23
    **/
    public static String toJson( Object src){
        return gson.toJson(src);
    }

    /**
     * json 转对象
     * @author dora 
     * @return   
     * @date 2019/10/23
    **/
    public static <T> T fromJson( String json, @NotNull Class<T> classOfT ){
        return gson.fromJson(json,classOfT);
    }

    /**
     * 文本转list
     * @author dora 
     * @return   
     * @date 2019/10/23
    **/
    public static <T> List<T> textToList(String text,@NotNull Class<T> classOfT){
        return  gson.fromJson(text,new TypeToken<List<T>>(){}.getType());
    }




}
