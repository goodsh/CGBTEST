package com.db.sys.service;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysRole;



/**
 * @author 赵先生
 */
public interface SysRoleService {
    /**
     * 本方法中要分页查询角色信息,并查询角色总记录数据
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
    PageObject<SysRole> findPageObjects(String name ,Integer pageCurrent);

}
