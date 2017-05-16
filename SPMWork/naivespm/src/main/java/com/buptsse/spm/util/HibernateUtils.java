package com.buptsse.spm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 全局搜索，并没有被显式使用
 */
public final class HibernateUtils {

    private static SessionFactory sessionFactory;

    private HibernateUtils() {
    }

    static {
        try {
            // Hibernate4取得SessionFactory的方法
            Configuration config = new Configuration().configure();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .build();

            sessionFactory = config.buildSessionFactory(serviceRegistry);

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
