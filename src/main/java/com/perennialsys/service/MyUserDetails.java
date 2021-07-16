package com.perennialsys.service;

import com.perennialsys.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
public class MyUserDetails implements UserDetails {

    private final User currentUser;

    public MyUserDetails(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // TODO FIX THIS CODE
        /*
      List  user.getRoles();
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
*/
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (String role : Arrays.asList("EMP", "ADMIN", "LEAD", "ACC")) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUser.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return currentUser.isEnabled();
    }

}
