package ru.itgirl.library_project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    // Метод загрузки пользователя по имени для проверки аутентификации
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
