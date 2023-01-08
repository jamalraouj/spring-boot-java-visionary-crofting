package com.youcode.youbooking.service;

import java.util.List;

public interface IService <T , Long>{
    public T add(T t);
    public boolean delete(Long i);
    public T findOneById(Long i);
    public T update(T t);
    public List<T> findAll();



}
