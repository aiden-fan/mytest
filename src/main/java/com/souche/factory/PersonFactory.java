package com.souche.factory;

import com.souche.pojo.Person;

/***
 *@author fanmiao
 *@date 2020/5/24 1:59 下午 
 */
public interface PersonFactory<T extends Person> {
    T method(Integer id, String name, String addr);
}
