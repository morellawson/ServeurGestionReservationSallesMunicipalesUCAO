package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import javax.transaction.Transactional;


import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Gardien;

@Transactional
public interface GardienRepository  extends UserBaseRepository<Gardien>{
	
	

}
