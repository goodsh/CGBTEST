package com.db.sys.dao;

import com.db.common.vo.DeptNode;
import com.db.common.vo.Node;
import com.db.sys.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *  @return
 */
public interface SysDeptDao {
    /**
     * 查询所有菜单以及上级菜单信息(上级菜单信息中
     * 至少要包含一个菜单名称)。
     * @return
     */
    List<Map<String,Object>> findObjects();
    /**
     * 基于菜单id统计子菜单的个数
     * @param id
     * @return
     */
    int getChildCount(Integer id);
    /**
     * 根据id删除信息
     *@param id
     * @return
     */
    int delObject(Integer id);

    /**
     * 插入数据
     * @param entity
     * @return
     */

     int insertDeptObject(SysDept entity);
    /**
     * 查询菜单节点信息
     * 1)菜单id
     * 2)菜单名称
     * 3)上级菜单id
     * 将查询出的节点信息封装到Node对象
     * 1)一行记录一个node对象(行映射-rowMap)
     * 2)多个node对象存储到list集合
     * @return
     */
    List<DeptNode> findZtreeDeptNodes();

    /**
     * 修改数据
     * @param entity
     * @return
     */
    int updataDeptObject(SysDept entity);




}
