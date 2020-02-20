package com.db.sys.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface SysUserRoleDao {
    /**
     * 基于用户userId删除用户以及对应角色关系数据
     * @param userId
     * @return
     */
   int deleteObjectsByRoleId(Integer userId);

    /**
     * 基于id查询对应角色的信息
     * @param id
     * @return
     */
   List<Integer> findRoleIdsByUserId(Integer id);
    /**
     * 负责将用户与角色的关系数据写入到数据库
     * @param userId 用户id
     * @param roleIds 多个角色id
     * @return
     */
   int insertObject(@Param("userId")Integer userId,
                    @Param("roleIds")Integer [] roleIds);


}
