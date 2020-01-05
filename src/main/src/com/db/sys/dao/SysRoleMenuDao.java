package com.db.sys.dao;

public interface SysRoleMenuDao {
    /**
     * 接口中创建基于菜单id删除记录的方法
     * @param menuId
     * @return
     */
   int deleteObjectsByMenuId(Integer menuId);

    /**
     * 基于角色id删除关系数据
     * @param id
     * @return
     */
   int deleteObjectsByRoleId(Integer id);

}
