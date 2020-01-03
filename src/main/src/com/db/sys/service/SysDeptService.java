package com.db.sys.service;

import com.db.common.vo.DeptNode;
import com.db.sys.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * 实现部门模块
 * @author 赵先生
 */
public interface SysDeptService {
    /**
     * 查询所有菜单以及上一级菜单的菜单名称
     * 1)一行记录映射为一个map
     *   (key为查询结果中的字段名-元数据-MetaData)
     * 2)多行记录对应多个map
     * 3)多个map存储到list集合
     * @return
     */
    List<Map<String,Object>> deptfindObjects();
    /**
     * 基于菜单id删除:
     * 1)菜单自身信息
     * 2)菜单与角色关系数据
     * @param id
     * @return
     */
    int delObject(Integer id);

    /**
     * 插入数据
     * @param sysDept
     * @return
     */
    int insertDeptObject(SysDept sysDept);

    /**
     *查询节点信息
     * @return
     */
    List<DeptNode> findZtreeDeptNodes();

    /**
     * 修改数据
     * @param endes
     * @return
     */

    int updataDeptObject(SysDept endes);


}
