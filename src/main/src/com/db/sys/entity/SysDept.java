package com.db.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 赵先生
 */
public class SysDept implements Serializable {

    private static final long serialVersionUID = 8900133307419801743L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
    private Date createTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}