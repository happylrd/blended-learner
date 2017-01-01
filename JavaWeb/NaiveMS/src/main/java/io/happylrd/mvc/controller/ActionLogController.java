package io.happylrd.mvc.controller;

import io.happylrd.model.ResponseList;
import io.happylrd.model.ResponseObj;
import io.happylrd.model.UserActionLog;
import io.happylrd.service.ActionLogService;
import io.happylrd.utils.GsonUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/actionLog")
public class ActionLogController {

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping(value = "/findLogList"
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object findLog(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }

        int totalNum;
        ResponseList<UserActionLog> responseObj = new ResponseList<UserActionLog>();

        try {
            totalNum = actionLogService.getAllCount();
            totalNum = totalNum % pageSize > 0 ? totalNum / pageSize + 1 : totalNum / pageSize;

            List<UserActionLog> result = actionLogService.findAll(pageNum, pageSize);

            responseObj.setPageNum(pageNum);
            responseObj.setTotalNum(totalNum);
            responseObj.setPageSize(pageSize);
            if (result == null || result.size() == 0) {
                responseObj.setCode(ResponseObj.EMPTY);
                responseObj.setMsg("查询结果为空");
                return new GsonUtils().toJson(responseObj);
            }
            responseObj.setCode(ResponseObj.OK);
            responseObj.setMsg("查询成功");
            responseObj.setData(result);
            return new GsonUtils().toJson(responseObj);
        } catch (Exception e) {
            e.printStackTrace();
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("查询失败");
            return new GsonUtils().toJson(responseObj);
        }
    }
}
