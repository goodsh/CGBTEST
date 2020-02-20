package com.db.sys.service;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptVo;

import java.util.List;
import java.util.Map;

public interface SysUserService {
    /**
     * 根据用户名获取列表
     *
     * @param username
     * @param pageCurrent
     * @return
     */
    PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent);

    /**
     * 根据id启动信息
     *
     * @param id
     * @param validById
     * @param modifiedUser
     * @return
     */
    int validById(Integer id, Integer validById, String modifiedUser);

    /**
     * 基于id查询用户以及用户对应的部门，角色信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> findObjectById(Integer userId);

    /**
     * 保存
     *
     * @param endtrl
     * @return
     */
    int saveObject(SysUser endtrl, Integer[] roleIds);

    /**
     * 需修改
     * @param endeed
     * @return
     */
    int updataObject(SysUser endeed, Integer[] roleIds);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int delectObject( Integer id,SysUser endesda);
}
