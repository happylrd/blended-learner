package io.happylrd.service.serviceImpl;

import eu.bitwalker.useragentutils.UserAgent;
import io.happylrd.dao.ActionLogDao;
import io.happylrd.model.User;
import io.happylrd.model.UserActionLog;
import io.happylrd.service.ActionLogService;
import io.happylrd.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Service("actionLogService")
public class ActionLogServiceImpl implements ActionLogService {

    @Autowired
    private ActionLogDao actionLogDao;

    private UserActionLog userActionLog;

    public void add(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                queryString += key + "=" + value + "&";
            }
        }

        userActionLog = new UserActionLog();
        if(request.getSession().getAttribute("userInfo")!=null){
            userActionLog.setUsername(((User)request.getSession().getAttribute("userInfo")).getUsername());
        }

        userActionLog.setMethod(request.getMethod());
        userActionLog.setDescription(request.getRequestURI());
        if (!StringUtils.isEmpty(queryString)){
            userActionLog.setRequestBody(queryString);
        }

        if (request.getHeader("x-forwarded-for") == null) {
            userActionLog.setIpAddrV4(request.getRemoteAddr());
        } else {
            userActionLog.setIpAddrV4(request.getHeader("x-forwarded-for"));
        }
        userActionLog.setTime(new Date(System.currentTimeMillis()));
        userActionLog.setSessionId(request.getSession().getId());

        try {
            UserAgent agent = new UserAgent(request.getHeader("User-Agent"));
            userActionLog.setOsName(agent.getOperatingSystem().getName());
            userActionLog.setBrowserName(
                    StringUtils.isEmpty(agent.getBrowser().getName()) ? "" : agent.getBrowser().getName()
            );
            userActionLog.setBrowserVersion(
                    StringUtils.isEmpty(agent.getBrowserVersion().getVersion()) ? "" : agent.getBrowserVersion().getVersion()
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            actionLogDao.add(userActionLog);
        }
    }

    @Deprecated
    public void add(UserActionLog userActionLog) throws Exception {

    }

    public List<UserActionLog> findAll(int pageNum, int pageSize) {
        pageNum -= 1;
        return actionLogDao.findAll(pageNum * pageSize + 1, pageSize);
    }

    public int getAllCount() {
        return actionLogDao.getAllCount();
    }
}
