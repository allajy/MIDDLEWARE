package com.bxc.assemble.authsecurity.security.service;

import com.bxc.assemble.authsecurity.authen.AccountProcessApi;
import com.bxc.assemble.authsecurity.domain.SystemUserSubject;
import com.bxc.assemble.authsecurity.rbac.po.SystemUser;
import com.bxc.assemble.common.model.rpc.RpcRequest;
import com.bxc.assemble.common.model.rpc.RpcResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @project-name:callcenter
 * @package-name:com.bxc.callcenter.security.service
 * @description: SpringSecurity用户的业务实现
 */

@Component
public class SystemUserDataService implements UserDetailsService {


    @Autowired
    AccountProcessApi accountProcessApi;


    @Override
    public SystemUserSubject loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        SystemUser sysUserEntity = null;
        RpcResponse<SystemUser> response = accountProcessApi.selectUserByName(new RpcRequest<String>().setEnity(username));
        if(response.isSuccess()){
            sysUserEntity = response.getEntity();
        }
        if (Objects.nonNull(sysUserEntity)){
            // 组装参数
            SystemUserSubject selfUserEntity = new SystemUserSubject();
            BeanUtils.copyProperties(sysUserEntity,selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
