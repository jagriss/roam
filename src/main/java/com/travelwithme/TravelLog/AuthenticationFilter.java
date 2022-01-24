package com.travelwithme.TravelLog;

import com.travelwithme.TravelLog.controllers.AuthenticationController;
import com.travelwithme.TravelLog.models.User;
import com.travelwithme.TravelLog.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;


    private static final List<String> allowlist = Arrays.asList("/login", "/register", "/logout", "/css", "/images");

    private static boolean isAllowlisted(String path) {
        for (String pathRoot : allowlist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            // add user attribute to request object so we only need one database lookup for the user per request
            request.setAttribute("user", user);
            return true;
        }

        // Don't require sign-in for allowlisted pages
        if (isAllowlisted(request.getRequestURI())) {
            // returning true indicates that the request may proceed
            return true;
        }

        // The user is NOT logged in and trying to access a page that requires login
        response.sendRedirect("/login");
        return false;
    }

}
