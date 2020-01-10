package com.db.sys.dao;

import com.db.sys.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 将角色与菜单的关系数据保存到数据库
     * @param roleId
     * @param menuIds
     * @return
     */
   int insertObject(@Param("roleId")Integer roleId,
                    @Param("menuIds")Integer[] menuIds);

    /**
     * 2）基于角色id查询菜单信息
     * @param roleId
     * @return
     */
    List<Integer> findMenuIdsByRoleId(Integer roleId);


}
