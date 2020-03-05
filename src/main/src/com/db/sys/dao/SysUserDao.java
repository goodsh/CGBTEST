package com.db.sys.dao;

import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptVo;
import edu.princeton.cs.algs4.ST;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户模块
 * @author 赵先生
 */

public interface SysUserDao {
    /**
     * 接口中定义基于id查询有多少个员工的方法
     * @param id
     * @return
     */
    int getUserCountByDeptId(Integer id);

    /**
     * 按条件查询当前页记录
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */

    List<SysUserDeptVo> findPageObjects(@Param("username") String username,
                                  @Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize);
    /**
     * 按条件统计记录总数
     * @param username
     * @return
     */
    int getRowCount(@Param("username")String username);

    /**
     * 禁用或启用用户信息
     * @param id
     * @param valid
     * @param modifiedUser
     * @return
     */
    int validById(
            @Param("id")Integer id,
            @Param("valid")Integer valid,
            @Param("modifiedUser")String modifiedUser);

    /**
     * 基于用户id查询用户和所属部门信息
     * @param id
     * @return
     */
    SysUserDeptVo findObjectById(Integer id);

    /**
     * 将用户信息写入到数据库
     * @param entity
     * @return
     */
    int insertObject(SysUser entity);

    /**
     * 查询用户名是不是重复
     * @param username
     * @return
     */
    Boolean findObjectName(@Param("username") String username);

    /**
     * 更新用户自身信息
     * @param entity
     * @return
     */
    int updateObject(SysUser entity);

    /**
     * 根据id删除用户信息和用户角色
     * @param id
     *
     * @return
     */
    int delectsObject(Integer id);

    /**
     *基于用户名查找用户信息
     * @param username
     * @param
     * @return
     */
    SysUser findUserByUserName(@Param("username") String username);




}
