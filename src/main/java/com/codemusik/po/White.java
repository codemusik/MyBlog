package com.codemusik.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_white")
public class White {
    @Id
    @GeneratedValue
    private Long id;

    private String ip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "White{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                '}';
    }
}
