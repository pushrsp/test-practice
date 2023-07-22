package sample.firsttest.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.firsttest.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.firsttest.spring.api.service.product.request.ProductCreateServiceRequest;
import sample.firsttest.spring.api.service.product.response.ProductResponse;
import sample.firsttest.spring.domain.product.Product;
import sample.firsttest.spring.domain.product.ProductRepository;
import sample.firsttest.spring.domain.product.ProductSellingStatus;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);
    }

    private String createNextProductNumber() {
        String latestProductNumber = productRepository.findLatestProductNumber();
        if(Objects.isNull(latestProductNumber)) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);

        return String.format("%03d", latestProductNumberInt + 1);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
