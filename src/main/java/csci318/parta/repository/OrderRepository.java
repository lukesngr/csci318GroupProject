package csci318.parta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import csci318.parta.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}