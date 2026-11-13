package com.platzi.pizzeria.domain.service;

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
                        .roles(roles)
                        .accountLocked(entity.isLocked())
                        .disabled(entity.isDisabled())
                    .build();
    }

}
