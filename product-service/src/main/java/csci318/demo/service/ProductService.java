package csci318.demo.service;

import csci318.demo.controller.dto.ProductDTO;
import csci318.demo.model.Product;
import csci318.demo.model.ProductDetail;
import csci318.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return convertToDTO(optionalProduct.get());
        } else {
            // Handle not found scenario (throw an exception or return a default DTO)
            return null;
        }
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductDetail productDetail = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(productDetail);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductDetail existingProduct = (ProductDetail) optionalProduct.get();
            updateEntityFromDTO(productDTO, existingProduct);
            Product updatedProduct = productRepository.save(existingProduct);
            return convertToDTO(updatedProduct);
        } else {
            // Handle not found scenario (throw an exception or return a default DTO)
            return null;
        }
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getProductCategory());

        // You can set other fields from Product here if needed

        // Additional fields from ProductDetail
        if (product instanceof ProductDetail) {
            ProductDetail productDetail = (ProductDetail) product;
            productDTO.setDescription(productDetail.getDescription());
            productDTO.setComment(productDetail.getComment());
        }

        return productDTO;
    }

    private ProductDetail convertToEntity(ProductDTO productDTO) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setName(productDTO.getName());
        productDetail.setPrice(productDTO.getPrice());
        productDetail.setProductCategory(productDTO.getCategory());
        productDetail.setDescription(productDTO.getDescription());
        productDetail.setComment(productDTO.getComment());
        return productDetail;
    }

    private void updateEntityFromDTO(ProductDTO productDTO, ProductDetail product) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setProductCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setComment(productDTO.getComment());

        // Update other fields in ProductDetail here if needed
    }
}