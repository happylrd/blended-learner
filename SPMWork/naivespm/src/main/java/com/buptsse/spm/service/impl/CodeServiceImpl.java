package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ICodeDao;
import com.buptsse.spm.domain.Code;
import com.buptsse.spm.service.ICodeService;

@Transactional
@Service
public class CodeServiceImpl implements ICodeService {

    @Resource
    private ICodeDao iCodeDao;

    @Override
    public Code getCodeByTypeAndCode(String codeType, String codeCode) {
        Code code = new Code();
        String hql = " from Code where codeType=? and codeCode=?";
        List<Object> listParam = new ArrayList<>();
        listParam.add(codeType);
        listParam.add(codeCode);
        List list = iCodeDao.listCode(hql, listParam);
        if (list != null && list.size() > 0) {
            code = (Code) list.get(0);
        }
        return code;
    }
}
