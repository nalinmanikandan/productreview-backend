package com.backend2.productreview.mapper;
import com.backend2.productreview.entity.Product;
import com.backend2.productreview.dto.ProductDto;
public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getDescription(),
                product.getBrandName()
        );
    }


    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getDescription(),
                productDto.getBrandName()
        );
    }


}
