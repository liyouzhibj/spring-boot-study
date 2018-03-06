package com.liyouzhi.client.service;

public interface HttpClient<T, Y, U, I> {
    T get(Y y, U u, I i);
    T post(Y y,U u, I i);
}
