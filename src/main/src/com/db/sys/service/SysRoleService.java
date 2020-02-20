package com.db.sys.service;

import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.common.vo.SysRoleMenuResult;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;

import java.util.List;
import java.util.Map;


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

    /**
     * 基于id删除信息
     * @param id
     */
    int deleteObject(Integer id);

    /**
     * 保存数据信息
     * @param entity
     * @param menuIds
     * @return
     */
    int saveObject(SysRole entity,Integer[]menuIds);

    /**
     * 基于角色id查询角色name，note以及角色对应的
     * 菜单id
     * @param id
     * @return
     */
    SysRoleMenuVo findObjectById(Integer id);

    /**
     *获取所有的角色id,角色名
     * @return
     */
    List<CheckBox> findObjects();

    /**
     *
     * @param entity
     * @param menuIds
     * @return
     */
    int updateObject(SysRole entity,Integer[] menuIds);


}
