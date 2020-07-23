package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import java.util.Optional;

import javax.transaction.Transactional;




import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.User;


@Transactional
public interface UserRepository extends /*JpaRepository<User,Long>*/ UserBaseRepository<User>{
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
