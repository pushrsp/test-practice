package sample.firsttest.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.firsttest.spring.api.service.product.response.ProductResponse;
import sample.firsttest.spring.domain.product.Product;
import sample.firsttest.spring.domain.product.ProductRepository;
import sample.firsttest.spring.domain.product.ProductSellingType;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingTypeIn(ProductSellingType.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
