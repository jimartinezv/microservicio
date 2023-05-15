package com.uncoreclave.Autenticacion.repositorio;

import com.uncoreclave.Autenticacion.entidad.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
    Optional<AuthUser> findByEmail(String username);

}
