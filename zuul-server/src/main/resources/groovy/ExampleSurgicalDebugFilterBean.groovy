import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.util.HTTPRequestUtils

public class ExampleSurgicalDebugFilterBean extends ZuulFilter {

    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 96
    }

    @Override
    boolean shouldFilter() {
        RequestContext.currentContext.getRequest().getRequestURI().matches("/api/redirect.*")
    }

    @Override
    Object run() {

        RequestContext.currentContext.routeHost = new URL("http://example.com");
        if (HTTPRequestUtils.getInstance().getQueryParams() == null) {
            RequestContext.getCurrentContext().setRequestQueryParams(new HashMap<String, List<String>>());
        }
        HTTPRequestUtils.getInstance().getQueryParams().put("debugRequest", ["true"])
        RequestContext.currentContext.setDebugRequest(true)
        RequestContext.getCurrentContext().zuulToZuul = true

    }

}

beans {
    exampleSurgicalDebugFilterBean(ExampleSurgicalDebugFilterBean) {
        new ExampleSurgicalDebugFilterBean();
    }
}