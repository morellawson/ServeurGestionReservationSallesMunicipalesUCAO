package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.ERole;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
	Optional<Role> findByName(ERole name);

}
