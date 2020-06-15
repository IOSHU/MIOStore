/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


/**
 *
 * @author hieule
 */
public interface DAO<T> {
    T[] getAllNameLike(String name);
    T[] getAll();
    T get(String name);
    T get(int id);
    void add(T t);
    void update(T t);
    void remove(T t);
    boolean contain(T t);
}
