package com.db.sys.dao;

public interface SysUserDao {
    /**
     * 接口中定义基于id查询有多少个员工的方法
     * @param id
     * @return
     */
    int getUserCountByDeptId(Integer id);


}
