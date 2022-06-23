package com.xhu.security.pojo;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@Accessors(chain = true)
public class AuthUser implements UserDetails {

    private String username;
    private String password;
    private Boolean enabled;//账户是否激活
    private Boolean accountNonExpired;//账户是否过期
    private Boolean accountNonLocked;//账户是否被锁定
    private Boolean credentialsNonExpired;//密码是否国企
    private List<Role> roles = new ArrayList<>();//关系属性，用于存储当前用户所有角色信息

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> list = new HashSet<>();
        roles.forEach(role -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
            list.add(simpleGrantedAuthority);
        });
        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
