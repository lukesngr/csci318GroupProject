package csci318.parta.controller;

import csci318.parta.repository.OrderRepository;
import csci318.parta.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order")
    List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/order")
    Order createOrder(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

}