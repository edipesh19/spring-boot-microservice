package org.sb.microservice.zuul.api.gateway.service.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class.getName());

    /**
     * When the filter should execute before the request ("pre")
     * after the response ("post") or in error case ("error")
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * This is the method to set the order among filters.
     * if there are multiple filter implementation is present
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Check the business logic whether this filter should be
     * executed or not
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Real logic of the filter
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("Request -> {}, Request uri -> {}", request, request.getRequestURI());
        return null;
    }
}
