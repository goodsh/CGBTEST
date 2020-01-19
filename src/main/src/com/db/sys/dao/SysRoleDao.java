package com.db.sys.dao;

import com.db.common.vo.SysRoleMenuResult;
import com.db.sys.vo.SysRoleMenuVo;
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
     *
     * @param name
     * @return
     */
    int getRowCount(@Param("name")String name);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int deleteObject(Integer id);

    /**
     * 将角色自身信息保存到数据库
     * @param entity
     * @return
     */
    int insertObject(SysRole entity);
    /**
     * 1）基于角色id查询角色信息以及菜单数据
     * @param id
     * @return
     */
    SysRoleMenuVo findObjectById(Integer id);

    /**
     * 添加角色修改的方法
     * @param  entity
     * @return
     */
    int updateObject(SysRole entity);





}
