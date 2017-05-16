package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Code;

// 数据字典接口
public interface ICodeDao {

    boolean saveCode(Code Code);

    boolean updateCode(Code Code);

    boolean removeCode(Code Code);

    boolean saveOrUpdateCode(Code Code);

    List<Code> listCode(String hql, Object[] param);

    List<Code> listCode(String hql, List<Object> param);

    Code getCodeById(Integer id);

    Long countCode(String hql, List<Object> param);
}
