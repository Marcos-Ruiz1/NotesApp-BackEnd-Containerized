package com.apipackendnotes.apibackendnotes.Services.Interfaces;

import java.util.List;

public interface IServiceBase<T> {

    public T add(T object);
    public T update(T object);
    public void delete(T object);
    public T find(T object);
    public T findById(T object);
    public List<T> findAll();
}
