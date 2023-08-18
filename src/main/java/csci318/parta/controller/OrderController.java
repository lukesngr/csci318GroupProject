package csci318.parta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import csci318.parta.model.Orderx;
import csci318.parta.repository.OrderRepository;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //@GetMapping is for GET requests
    @GetMapping("/order")
    List<Orderx> findAllOrders() {
        return orderRepository.findAll();
    }

    //this is used to find order id
    @GetMapping("/order/{id}")
    Orderx findOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/order")
    Orderx createOrder(@RequestBody Orderx newOrder) {
        return orderRepository.save(newOrder);
    }

    //put order by id
    @PutMapping("/order/{id}")
    Orderx updateOrderProduct(@PathVariable Long id, @RequestBody Orderx order) {
        Orderx order1 = orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        order1.setProduct(order.getProduct());
        return orderRepository.save(order1);
    }

}
