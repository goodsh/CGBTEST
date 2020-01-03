package com.db.sys.service.impl;

import cgb.java.reflect.serializable.SysUser;
import com.db.common.exception.ServiceException;
import com.db.common.vo.DeptNode;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.dao.SysUserDao;
import com.db.sys.entity.SysDept;
import com.db.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 部门实现类
 *
 * @author 赵先生
 */
@Service
public class SysDeptServiceImpI implements SysDeptService {
    @Autowired
    private SysDeptDao sysDeptDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<Map<String, Object>> deptfindObjects() {
        List<Map<String, Object>> list =
                sysDeptDao.findObjects();
        if (list == null || list.size() == 0) {
            throw new ServiceException("没有对应记录");
        }

        return list;
    }

    @Override
    public int delObject(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id值无效");
        }
        //2.基于id查询统计子菜单并进行校验
        int childCount = sysDeptDao.getChildCount(id);
        if (childCount > 0) {
            throw new ServiceException("请先删除子菜单");
        }
        //2.2判定此部门是否有用户
        int usernd = sysUserDao.getUserCountByDeptId(id);
        if (usernd > 0) {
            throw new ServiceException("此部门有员工，不允许对部门进行删除");
        }
        //2.2判定此部门是否已经被用户使用,假如有则拒绝删除
        //3.删除菜单自身信息
        int rowd = sysDeptDao.delObject(id);
        if (rowd == 0) {
            throw new ServiceException("记录可能已经不存在");
        }
        return rowd;
    }

    @Override
    public int insertDeptObject(SysDept sysDept) {
        if (sysDept == null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(sysDept.getName())) {
            throw new IllegalArgumentException("菜单名不为空");
        }
        int a = sysDeptDao.insertDeptObject(sysDept);
        return a;
    }

    @Override
    public List<DeptNode> findZtreeDeptNodes() {
         List<DeptNode> list= sysDeptDao.findZtreeDeptNodes();
        if(list==null||list.size()==0){
            throw new ServiceException("还没有其它菜单");
        }

        return list;
    }

    @Override
    public int updataDeptObject(SysDept endes) {
        if(endes==null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(endes.getName())){
         throw new IllegalArgumentException("菜单名不能为空");
        }

        int rowes=sysDeptDao.updataDeptObject(endes);

        return rowes;
    }
}
