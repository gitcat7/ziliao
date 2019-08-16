package utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yk
 * @date 2019/8/13 - 10:44
 * 配置拦截器
 */
public class LoginIntercepter implements HandlerInterceptor {

    /**
     * 请求执行目标方法前执行的操作
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("进入拦截器");
        System.out.println("目标方法执行前");
        Object obj = request.getSession().getAttribute("myUser");
        String path = request.getContextPath();
        String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        if(obj!=null){
            return true;
        }
        request.getSession().setAttribute("prompt","请先登录,再操作!");
        response.sendRedirect(basepath+"login.jsp");
        return false;
    }

    /**
     * 请求执行目标方法后执行的操作
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView){
        System.out.println("目标方法执行后");
    }

    /**
     * 最终的操作,一般用来释放资源
     * @param request
     * @param response
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        System.out.println("退出拦截器");
    }
}
