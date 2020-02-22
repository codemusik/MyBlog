package com.codemusik.bo;

import java.math.BigInteger;

public class TypeOrTagBlog {

    private BigInteger id;
    private String name;
    private BigInteger blog_number;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBlog_number() {
        return blog_number;
    }

    public void setBlog_number(BigInteger blog_number) {
        this.blog_number = blog_number;
    }

    public TypeOrTagBlog() {
    }

    public TypeOrTagBlog(BigInteger id, String name, BigInteger blog_number) {
        this.id = id;
        this.name = name;
        this.blog_number = blog_number;
    }

    @Override
    public String toString() {
        return "TypeOrTagBlog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blog_number=" + blog_number +
                '}';
    }
}
