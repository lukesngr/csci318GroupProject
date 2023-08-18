package csci318.parta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import csci318.parta.model.Orderx;

public interface OrderRepository extends JpaRepository<Orderx, Long> {

}
