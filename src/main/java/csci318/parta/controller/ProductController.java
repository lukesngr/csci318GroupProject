package csci318.parta.controller;
import csci318.parta.model.Product;
import csci318.parta.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository xrepository;


    public ProductController(ProductRepository xrepository) {
        this.xrepository = xrepository;
    }

    //@GetMapping is responsible for GET requests
    @GetMapping("/product")
    List<Product> all(){
        return xrepository.findAll();
    }

    //Finds Product by id
    @GetMapping("/product/{id}")
    Product findProdById(@PathVariable Long id) {
        return xrepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

//    @GetMapping("/product/{id}/detail")
//    Product findProdDetailById(@PathVariable Long id) {
//        return xrepository.findById(id)
//                .orElseThrow(RuntimeException::new);
//    }

    @PostMapping("/product")
    Product createProd(@RequestBody Product newProd) {
        return xrepository.save(newProd);
    }

    //Puts product by ID
    @PutMapping("/product/{id}")
    Product updateProdName(@PathVariable Long id, @RequestBody Product product) {
        Product product1 = xrepository.findById(id)
                .orElseThrow(RuntimeException::new);
        product1.setName(product.getName());
        return xrepository.save(product1);
    }


}