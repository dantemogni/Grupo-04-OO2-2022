package com.unla.tp.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//SOBREESCRIBE EL COMANDO delete CONVIRTIÉNDOLE EN UN update
@SQLDelete(sql = "UPDATE usuario SET enabled = false WHERE id = ?")
//CUANDO SE LEAN LOS USUARIOS, SE IGNORARAN LOS QUE TENGAN enabled = false
@Where (clause = "enabled=true")
@Table(name = "usuario")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String tipoDocumento;

    @Column(nullable = false)
    private Double nroDocumento;


    //COLUMNA PARA BORRADO LÓGICO CON @Builde.Default PARA QUE @BUILDER NO IGNORE SU INICIALIZACIÓN DE TRUE.
    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.EAGER, optional = false) // ver el "EAGER"
    @JoinColumn(name = "id_role")
    private Role role;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
