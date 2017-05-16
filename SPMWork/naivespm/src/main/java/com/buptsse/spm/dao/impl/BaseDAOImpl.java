package com.buptsse.spm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IBaseDAO;

@Repository("baseDAO")
@SuppressWarnings("all")
public class BaseDAOImpl<T> implements IBaseDAO<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }

    @Override
    public void remove(T o) {
        this.getCurrentSession().delete(o);
    }

    @Override
    public void update(T o) {
        this.getCurrentSession().update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public List<T> list(String hql) {
        return this.getCurrentSession().createQuery(hql)
                .list();
    }

    @Override
    public List<T> list(String hql, Object[] param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return query.list();
    }

    @Override
    public List<T> list(String hql, List<Object> param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return query.list();
    }

    @Override
    public List<T> list(String hql, Object[] param, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }

        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return query.setFirstResult((pageNum - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public List<T> list(String hql, List<Object> param, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }

        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return query.setFirstResult((pageNum - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public T get(Class<T> cls, Serializable id) {
        return (T) this.getCurrentSession().get(cls, id);
    }

    public T get(String hql, Object[] param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return (T) query.uniqueResult();
    }

    public T get(String hql, List<Object> param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return (T) query.uniqueResult();
    }

    /*
    sql 必须类似 select count(*) from ...
    个人感觉与hql强相关，并不能封装成count。
     */
    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql)
                .uniqueResult();
    }

    public Long count(String hql, Object[] param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return (Long) query.uniqueResult();
    }

    public Long count(String hql, List<Object> param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return (Long) query.uniqueResult();
    }

    @Override
    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql)
                .executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, Object[] param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                query.setParameter(i, param[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, List<Object> param) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return query.executeUpdate();
    }
}