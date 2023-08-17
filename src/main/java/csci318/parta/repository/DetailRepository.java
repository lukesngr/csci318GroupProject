package csci318.parta.repository;

import csci318.parta.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<ProductDetail, Long> {

}
