package com.db.sys.service.impl;

import com.db.common.exception.ServiceException;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志分页，和获取
 *
 * @author zhaofen
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前页码不对");
        }
        int rowCount = sysLogDao.getRowCount(username);
        if (rowCount == 0) {
            throw new RuntimeException("没有对应记录");
        }
//3.基于条件查询当前页记录(pageSize定义为3)
        int pageSize = 3;
        int startIndex = (pageCurrent - 1) * pageSize;
        List<SysLog> record =
                sysLogDao.findPageObjects(username, startIndex, pageSize);
//4.2)封装数据
        PageObject<SysLog> pageObject = new PageObject<>();

        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(record);
/*       int pageCount = rowCount/pageSize;
//        if (rowCount%pageSize!=0){
//            pageCount++
} */
        pageObject.setPageCount((rowCount - 1) / pageSize + 1);

        return pageObject;
    }

    @Override
    public int deleteObjects(Integer... ids) {
        //1.判定参数合法性
        if (ids == null || ids.length == 0) {
            throw new IllegalArgumentException("请先选择");
        }
        //执行删除操作
        int rows;
        try {
            rows = sysLogDao.deleteObjects(ids);
        } catch (Throwable e) {
            e.printStackTrace();
            //发出报警信息(例如给运维人员发短信)
            throw new ServiceException("系统故障，正在恢复中...");
        }
            //对结果进行验证
        if (rows == 0) {
            throw new ServiceException("记录可能已经不存在");
        }
        return rows;
    }
}
