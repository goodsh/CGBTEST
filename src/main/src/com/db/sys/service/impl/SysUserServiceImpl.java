package com.db.sys.service.impl;

import com.db.common.exception.ServiceException;
import com.db.common.util.PageUtil;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptVo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 赵先生
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("参数不合法");
        }
        //2.依据条件获取总记录数
        int rowCount = sysUserDao.getRowCount(username);
        if (rowCount == 0) {
            throw new ServiceException("记录不存在");
        }
        //3.查询当前页数据
        Integer pageSize = 3;
        Integer startIndex = (pageCurrent - 1) * pageSize;
        //4.依据条件获取当前页数据
        List<SysUserDeptVo> records =
                sysUserDao.findPageObjects(username, startIndex, pageSize);

        return PageUtil.newPageObject(rowCount,
                records, pageCurrent, pageSize);
    }

    @Override
    public int validById(Integer id, Integer validById, String modifiedUser) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("参数不合法,id=" + id);
        }
        if (validById != 0 && validById != 1) {
            throw new IllegalArgumentException("状态值不正确,validById=" + validById);
        }
        if (StringUtils.isEmpty(modifiedUser)) {
            throw new ServiceException("请先登录,修改用户不能为空");
        }
        //2.执行禁用或启用操作
        int rows = 0;
        try {
            rows = sysUserDao.validById(id, validById, modifiedUser);
        } catch (Throwable e) {
            e.printStackTrace();
            //报警,给维护人员发短信
            throw new ServiceException("底层正在维护");
        }
        if (rows == 0) {
            throw new ServiceException("此记录可能已经不存在");
        }
        return rows;
    }

    @Override
    public Map<String, Object> findObjectById(Integer userId) {
        //1.合法性验证
        if (userId < 1 || userId == null) {
            throw new IllegalArgumentException("id值不合法");
        }
        /** 根据id查询数据*/
        SysUserDeptVo sysUserDeptVo = sysUserDao.findObjectById(userId);
        //3.基于用户id查询角色信息
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
        //4.对查询结果进行封装
        Map<String, Object> map = new HashMap<>();
        map.put("user", sysUserDeptVo);
        map.put("roleIds", roleIds);
        return map;
    }

    @Override
    public int saveObject(SysUser endtrl, Integer[] roleIds) {
        if (endtrl == null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(endtrl.getUsername())) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (StringUtils.isEmpty(endtrl.getPassword())) {
            throw new IllegalArgumentException("密码不能为空");
        }
        if (roleIds == null || roleIds.length == 0) {
            throw new IllegalArgumentException("必须为其指定角色");
        }
        Boolean firstName = sysUserDao.findObjectName(endtrl.getUsername());
        //取得response 实例 ServletActionContext
        if (firstName != null) {
            throw new ServiceException("用户名字已经存在");
        }
        //其它验证自己实现，例如用户名已经存在，密码长度，...
        //2.保存用户自身信息
        //2.1生成一个salt值
        String salt = UUID.randomUUID().toString();
        //2.2对密码进行验证加密
        SimpleHash sh = new SimpleHash(//此api需要添加shiro依赖
                "MD5",//algorithmName (相同内容加密结果一样)
                endtrl.getPassword(),//source
                salt, 1);
        endtrl.setSalt(salt);
        endtrl.setPassword(sh.toHex());
        int rows = sysUserDao.insertObject(endtrl);
        //3.保存用户与角色关系数据
        sysUserRoleDao.insertObject(endtrl.getId(),
                roleIds);
        //4.返回结果
        return rows;
    }

    @Override
    public int updataObject(SysUser endeed, Integer[] roleIds) {
        if (endeed == null) {
            throw new ServiceException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(endeed.getUsername())) {
            throw new ServiceException("用户名字不能为空");
        }
        if (roleIds == null || roleIds.length == 0) {
            throw new ServiceException("必须为其指定角色");
        }
        Boolean firstName=sysUserDao.findObjectName(endeed.getUsername());
        //取得response 实例 ServletActionContext
        if (firstName != null) {
            throw new ServiceException("用户名字已经存在");
        }
        //2.更新用户自身信息
        int row = sysUserDao.updateObject(endeed);
        sysUserRoleDao.deleteObjectsByRoleId(endeed.getId());
        sysUserRoleDao.insertObject(endeed.getId(), roleIds);
        return row;
    }

    @Override
    public int delectObject(Integer id ,SysUser endesda) {
        if (id==null){
            throw new IllegalArgumentException("请先选择");
        }
        int a=sysUserDao.delectsObject(id);
        if (a==0){
            throw new IllegalArgumentException("记录已经不存在");
        }
        sysUserRoleDao.deleteObjectsByRoleId(endesda.getId());
        return a;
    }


}
