package com.baizhi.realm;

import java.util.List;



import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Resources;
import com.baizhi.entity.Role;
import com.baizhi.service.AdminService;


public class Myrealm extends AuthorizingRealm{
	@Autowired
	private AdminService adminService;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		// TODO Auto-generated method stub
		//获得密码
		String adminname = (String) pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//根据账户查询密码 
		List<Role> roles = adminService.queryRoleByName(adminname);
		System.out.println(roles);
		for (Role role : roles) {
			System.out.println(role);
			authorizationInfo.addRole(role.getRolename());
		}
		//根据用户名查询资源
		List<Resources> rs = adminService.querySourceByName(adminname);
		for (Resources resources : rs) {
			authorizationInfo.addStringPermission(resources.getTag());
		}
		return authorizationInfo;
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获得用户名
		String adminname = (String) token.getPrincipal();
		//数据库查询 
		Admin admin = adminService.queryByName(adminname);
		if(admin!=null){
			return new SimpleAuthenticationInfo(adminname,admin.getPassword(),ByteSource.Util.bytes(admin.getSalt()),getName());
			
		}
		return null;
	}

}
