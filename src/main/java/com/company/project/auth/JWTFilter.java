package com.company.project.auth;


import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/06
 * Time: 11:09
 */
@Slf4j
public class JWTFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取Authorization字段
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization!=null) {
            try{
                JWTToken token = new JWTToken(authorization);
                // 提交给realm进行登入，如果错误他会抛出异常并被捕获
                getSubject(request, response).login(token);
                return true;
            }catch (Exception e){
                //onLoginFail(response);
                response401(request, response);
                return false;
            }
        } else {
            response401(request, response);
            return false;
        }
    }

    /**
     * 失败返回401状态码
     * @param response
     * @throws IOException
     */
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        Result result = new Result();
       // httpResponse.send
        result.setCode(ResultCode.UNAUTHORIZED);
        result.setMessage("invalid token");
        PrintWriter pw = httpResponse.getWriter();
       // pw.write(JSONObject.toJSONString(response));
        log.error("error");
        httpResponse.sendError(401);
    }

    /**
     * 将请求返回到 /401
     */
    private void response401(ServletRequest req, ServletResponse resp) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        httpServletRequest.getRequestDispatcher("/auth/unauthorized").forward(httpServletRequest, httpServletResponse);
        //httpServletResponse.sendRedirect("/auth/unauthorized");
    }
}