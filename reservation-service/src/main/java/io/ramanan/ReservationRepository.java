package io.ramanan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ramanan on 9/25/16.
 */

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long>{



}
