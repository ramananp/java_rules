package io.ramanan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ramanan on 9/25/16.
 */

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;

	private String reservationName; //reservation_name

	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}

	Reservation(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", reservationName='" + reservationName + '\'' +
				'}';
	}
}
