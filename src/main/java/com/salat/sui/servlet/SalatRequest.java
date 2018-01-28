/** servletPackage */
package com.salat.sui.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** SalatRequestClass */
public class SalatRequest extends HttpServletRequestWrapper {

    /**
     * DefaultConstrustors
     *
     * @param request
     */
    public SalatRequest(HttpServletRequest request) {
        super(request);
    }

}
