package com.buptsse.spm.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T> {

    Serializable save(T o);

    void remove(T o);

    void update(T o);

    void saveOrUpdate(T o);

    List<T> list(String hql);

    // 条件查询
    List<T> list(String hql, Object[] param);

    List<T> list(String hql, List<Object> param);

    // 分页查询
    List<T> list(String hql, Object[] param, Integer pageNum, Integer pageSize);

    List<T> list(String hql, List<Object> param, Integer pageNum, Integer pageSize);

    /**
     * @param cls 持久类
     * @param id  主键
     */
    T get(Class<T> cls, Serializable id);

    // 条件查询
    T get(String hql, Object[] param);

    T get(String hql, List<Object> param);

    Long count(String hql);

    Long count(String hql, Object[] param);

    Long count(String hql, List<Object> param);

    /**
     * 执行HQL语句，没有被使用
     *
     * @param hql
     * @return 受影响的行数
     */
    Integer executeHql(String hql);

    Integer executeHql(String hql, Object[] param);

    Integer executeHql(String hql, List<Object> param);
}