package io.happylrd.model;

import java.io.Serializable;
import java.sql.Date;

public class UserActionLog implements Serializable {
    private long id;
    private String username;

    private String method;
    private String description;
    private String requestBody;

    private String ipAddrV4;
    private String ipAddrV6;
    private Date time;
    private String sessionId;

    private String osName;
    private String osVersion;
    private String browserName;
    private String browserVersion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getIpAddrV4() {
        return ipAddrV4;
    }

    public void setIpAddrV4(String ipAddrV4) {
        this.ipAddrV4 = ipAddrV4;
    }

    public String getIpAddrV6() {
        return ipAddrV6;
    }

    public void setIpAddrV6(String ipAddrV6) {
        this.ipAddrV6 = ipAddrV6;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    @Override
    public String toString() {
        return "UserActionLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", method='" + method + '\'' +
                ", description='" + description + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", ipAddrV4='" + ipAddrV4 + '\'' +
                ", ipAddrV6='" + ipAddrV6 + '\'' +
                ", time=" + time +
                ", sessionId='" + sessionId + '\'' +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", browserName='" + browserName + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                '}';
    }
}
