package com.buptsse.spm.interceptor;

import com.buptsse.spm.common.Const;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class UserMustLoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        if (session.get(Const.CURRENT_USER) != null) {
            String result = invocation.invoke();
            return result;
        } else {
            // TODO: will be improved later
            return "need_login";
        }
    }
}
