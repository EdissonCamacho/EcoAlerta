package com.ecoalerta.Operaciones;

import com.ecoalerta.Model.Rol;

import com.ecoalerta.Model.RolUsuario;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceRol;

import com.ecoalerta.Services.ServiceRolUsuario;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ecoalerta.util.JwtUtils;
import com.ecoalerta.Controller.dto.AuthLoginRequest;
import com.ecoalerta.Model.Usuario;

import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ServiceUsuario userRepository;
    @Autowired
    private ServiceRol serviceRol;
    @Autowired
    private ServiceRolUsuario serviceRolUsuario;

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

    public String createUser(Usuario usuario){

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario userSaved= userRepository.save(usuario);
        Optional<Rol> rol = serviceRol.findById(1);
        RolUsuario ru= new RolUsuario();
        ru.setIdRolFk(rol.get());
        ru.setIdUsuarioFk(userSaved);



        serviceRolUsuario.save(ru);



        Collection<Rol> roles= serviceRol.findRolesByUsuario(userSaved.getUsuario());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if(roles.isEmpty()){
            throw new IllegalArgumentException("The roles specified does not exist.");
        }
        roles.forEach(
                role-> authorityList.add(new SimpleGrantedAuthority("Role".concat(role.getNombreRol())))
        );
        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorityList);
        return  jwtUtils.createToken(authentication);



    }

    public String loginUser(AuthLoginRequest authLoginRequest) {

        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

       return jwtUtils.createToken(authentication);

    }


    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException(String.format("Invalid username or password"));
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }





}
