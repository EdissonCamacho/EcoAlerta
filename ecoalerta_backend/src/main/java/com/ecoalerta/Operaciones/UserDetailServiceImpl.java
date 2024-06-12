package com.ecoalerta.Operaciones;

import com.ecoalerta.Model.Rol;
import com.ecoalerta.Model.RolUsuario;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceRol;
import com.ecoalerta.Services.ServiceRolUsuario;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private ServiceUsuario userRepository;
    @Autowired
    private ServiceRol serviceRol;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u=  userRepository.findByUsuario(username)
                .orElseThrow(()->new UsernameNotFoundException("No se encontro el usuario: "+username));
        Collection<Rol> roles= serviceRol.findRolesByUsuario(username);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        roles.forEach(
                role-> authorityList.add(new SimpleGrantedAuthority("Role".concat(role.getNombreRol())))
        );

        return new User(
                u.getUsuario(),
                u.getPassword(),
                u.isEnabled(),
                u.isAccountNoExpired(),
                u.isCredentialNoExpired(),
                u.isAccountNoLocked(),
                authorityList


        );




    }
}
