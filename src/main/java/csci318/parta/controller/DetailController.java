package csci318.parta.controller;

import csci318.parta.model.ProductDetail;
import csci318.parta.repository.DetailRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailController {

    private final DetailRepository xrepository;

    public DetailController(DetailRepository xrepository){this.xrepository = xrepository; };

//    @GetMapping("/product/{id}/detail")
//    ProductDetail getDetailById(@PathVariable Long id) {
//        return xrepository.findById(id)
//                .orElseThrow(RuntimeException::new);
//    }

    //Puts product by ID
    @PostMapping("/product/{id}/detail")
    ProductDetail updateProdName(@PathVariable Long id, @RequestBody ProductDetail product) {
        ProductDetail product1 = xrepository.findById(id)
                .orElseThrow(RuntimeException::new);
        product1.setDescription(product.getDescription());
        product1.setComment(product.getComment());
        return xrepository.save(product1);
    }


}
