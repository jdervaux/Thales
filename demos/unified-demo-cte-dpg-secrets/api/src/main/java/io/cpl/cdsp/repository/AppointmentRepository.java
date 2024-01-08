/**
 * 
 */
package io.cpl.cdsp.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import io.cpl.cdsp.model.Appointment;

/**
 * @author Anurag Jain, developer advocate Thales Group
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	ArrayList<Appointment> findByDoctor(String doctor);
	ArrayList<Appointment> findByPatient(String patient);
}
