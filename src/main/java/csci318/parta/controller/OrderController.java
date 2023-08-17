package csci318.parta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import csci318.parta.model.Order;
import csci318.parta.repository.OrderRepository;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //@GetMapping is for GET requests
    @GetMapping("/order")
    List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    //this is used to find order id
    @GetMapping("/order/{id}")
    Order findOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/order")
    Order createOrder(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

    //put order by id
    @PutMapping("/order/{id}")
    Order updateOrderProduct(@PathVariable Long id, @RequestBody Order order) {
        Order order1 = orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        order1.setProduct(order.getProduct());
        return orderRepository.save(order1);
    }

}
