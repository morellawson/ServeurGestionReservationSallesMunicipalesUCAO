package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T,Long> {

	public T findByEmail(String email);
}
