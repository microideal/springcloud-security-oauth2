package com.microideal.authserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.DomainEvents;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @GenericGenerator(name ="system-uuid", strategy ="uuid")
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @NotNull
    @Size(min = 1,max = 20)
    @Column(length = 20,unique = true,nullable = false)
    private String username;

    @NotNull
    @Column(length = 60)
    private String password;

    @NotNull
    @Column
    private String authority;

    @Transient
    private String test = "test";


    public Set<GrantedAuthority> getAuthorities(){
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        userAuthorities.add(new SimpleGrantedAuthority(this.authority));
        return userAuthorities;
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

    @DomainEvents
    Collection<Object> domainEvents(){
        List<Object> events= new ArrayList<Object>();
        events.add(this);
        return events;
    }
}
