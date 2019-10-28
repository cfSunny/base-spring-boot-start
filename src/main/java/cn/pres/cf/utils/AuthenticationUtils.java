package cn.pres.cf.utils;

import cn.pres.cf.interceptor.AuthenticationInfo;

/**
 * @author Dora
 * @date 2019/10/28 8:52
 **/
public class AuthenticationUtils {
    private static  ThreadLocal threadLocal=new ThreadLocal<>();



    public static <T> void init(T data){
        threadLocal.set(data);
    }

    public static <T> T getAuthenticationInfo(){
        return (T)threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
