package ru.shavykin.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shavykin.model.User;
import ru.shavykin.repository.UserRepository;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository repo;

    @Autowired
    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repo.findByLogin(login);
        if (user == null) {
            return null;
        }
        String role = user.getRole();
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(login, password, auth);
    }

}

