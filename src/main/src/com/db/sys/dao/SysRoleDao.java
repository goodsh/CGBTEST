package com.db.sys.dao;

import com.db.sys.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleDao {
    /**
     * 分页查询角色信息
     *2)负责基于条件查询当前页数据
     * @param startIndex 上一页的结束位置
     * @param pageSize   每页要查询的记录数
     * @return
     */
    List<SysRole> findPageObjects(@Param("name") String name,
                                  @Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize
    );
    /**
     * 查询记录总数
     * @return
     */
    int getRowCount(@Param("name")String name);
}