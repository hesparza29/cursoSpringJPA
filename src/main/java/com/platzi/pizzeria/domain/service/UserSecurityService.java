package com.platzi.pizzeria.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.platzi.pizzeria.persistence.entity.UserEntity;
import com.platzi.pizzeria.persistence.entity.UserRoleEntity;
import com.platzi.pizzeria.persistence.repository.UserEntityRepository;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserEntityRepository repository;

    public UserSecurityService(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity entity = this.repository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

        String[] roles = entity.getRoles().stream()
                                .map((UserRoleEntity roleEntity) -> roleEntity.getRole())
                                .toArray(String[]::new);

        return User.builder()
                        .username(entity.getUsername())
                        .password(entity.getPassword())
                        .authorities(this.getAuthorities(roles))
                        .accountLocked(entity.isLocked())
                        .disabled(entity.isDisabled())
                    .build();
    }

    private List<SimpleGrantedAuthority> getAuthorities(String[] roles) {
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            if(role.equalsIgnoreCase("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("orders"));
            }
        }
    
        return authorities;
    }

}
