package cn.pres.cf.interceptor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dora
 * @date 2019/10/25 14:08
 **/
public interface Authenticator<T> {
    /**
     * 权限处理
     * @author dora 
     * @return
     * @param request
     * @date 2019/10/25
    **/
    T authenticate(HttpServletRequest request);
}
