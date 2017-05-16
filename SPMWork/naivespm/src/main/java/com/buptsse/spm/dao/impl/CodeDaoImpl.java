package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ICodeDao;
import com.buptsse.spm.domain.Code;

@Repository
public class CodeDaoImpl extends BaseDAOImpl<Code> implements ICodeDao {

    private static Logger logger = Logger.getLogger(CodeDaoImpl.class);

    @Override
    public boolean saveCode(Code code) {
        try {
            super.save(code);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCode(Code code) {
        try {
            super.update(code);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCode(Code code) {
        try {
            super.remove(code);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateCode(Code code) {
        try {
            super.saveOrUpdate(code);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Code> listCode(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<Code> listCode(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public Code getCodeById(Integer id) {
        return super.get(Code.class, id);
    }

    @Override
    public Long countCode(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
