package com.vanhi.appointger.repository;

import com.vanhi.appointger.enumeration.Specialty;
import com.vanhi.appointger.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByDate(Date date);
    Appointment findBySpecialty (Specialty specialty);
    List<Appointment> findByPersonId (Long id);

}
