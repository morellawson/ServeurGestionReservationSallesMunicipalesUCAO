package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import javax.transaction.Transactional;



import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Employe;

@Transactional
public interface EmployeRepository extends UserBaseRepository<Employe> {

}
