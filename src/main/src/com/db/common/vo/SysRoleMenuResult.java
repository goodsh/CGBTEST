package com.db.common.vo;

import com.db.sys.entity.SysRole;

import java.util.List;


/**
 * @author 赵先生
 */
public class SysRoleMenuResult {
	/**角色对象*/
	private SysRole role;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
}