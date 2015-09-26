package us.pdavidson.sample.oauth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final Set<User> users;


    public CustomUserDetailService() {
        users = new HashSet<>();
        users.add(
            User.newBuilder()
                .withUserId(1l)
                .withUsername("admin")
                .withPassword("admin1")
                .build()
        );

        users.add(
                User.newBuilder()
                        .withUserId(2l)
                        .withUsername("testuser")
                        .withPassword("testuser1")
                        .build()
        );

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User " + s + " not found"));

        return new CustomUserDetails(user);
    }

    private final static class CustomUserDetails implements UserDetails {

        private final User user;

        CustomUserDetails(User user){
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.emptySet();
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
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
            return true;
        }
    }
}
