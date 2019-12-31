package com.cjy.anno.bean;

import com.cjy.anno.api.Column;
import com.cjy.anno.api.Id;
import com.cjy.anno.api.TableRef;

@TableRef(value = "t_person")
public class Person {
    @Id
    private Integer id;
    @Column(family = "ps",column = "name22")
    private String name;

    @Column(family = "ps")
    private String email;

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;

        this.email = email;
    }

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
