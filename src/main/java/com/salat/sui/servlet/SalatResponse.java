/** sservletPackage */
package com.salat.sui.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/** SalatResponseClass */
public class SalatResponse extends HttpServletResponseWrapper {

    /**
     * DefalutConstructors
     * 
     * @param response
     */
    public SalatResponse(HttpServletResponse response) {
        super(response);
    }

}
