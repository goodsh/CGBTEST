package com.db.sys.service.impl;

import com.db.common.exception.ServiceException;
import com.db.common.util.PageUtil;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前页码不正确");
        }
        //2.基于条件查询总记录数
        //2.1) 执行查询
        int rowCount = sysRoleDao.getRowCount(name);
        if (rowCount == 0) {
            throw new ServiceException("记录不存在");
        }
        //3.基于条件查询当前页记录(pageSize定义为3)
        //3.1)定义pageSize
        int pageSize = 3;
        //3.2)计算startIndex
        int startIndex = (pageCurrent - 1) * pageSize;
        //3.3)执行当前数据的查询操作
        List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        return PageUtil.newPageObject(rowCount,
                records, pageCurrent, pageSize);
    }

    @Override
    public int deleteObject(Integer id) {
        if (id == null || id < 1) {
            throw new ServiceException("id的值不正确,id=" + id);
        }

        //2.执行dao操作
        int roes = sysRoleDao.deleteObject(id);

        if (roes == 0) {
            throw new ServiceException("数据可能已经不存在");
        }
        sysRoleMenuDao.deleteObjectsByRoleId(id);
        sysUserRoleDao.deleteObjectsByRoleId(id);
        return roes;
    }

    @Override
    public int saveObject(SysRole entity, Integer[] menuIds) {
        //1.合法性验证
        if (entity == null) {
            throw new ServiceException("保存数据不能为空");
        }
        if (StringUtils.isEmpty(entity.getName())) {
            throw new ServiceException("角色名不能为空");
        }
        if (menuIds == null || menuIds.length == 0) {
            throw new ServiceException("必须为角色赋予权限");
        }
        int rows = sysRoleDao.insertObject(entity);
        sysRoleMenuDao.insertObject(entity.getId(),menuIds);
        return rows;
    }
}
