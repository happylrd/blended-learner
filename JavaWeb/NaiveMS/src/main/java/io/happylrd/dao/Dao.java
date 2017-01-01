package io.happylrd.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

    // return the affected line num
    int add(T t);

    int delete(T t);

    int update(T t);

    T findOneByUsername(Serializable username);

    List<T> findAll();
}
