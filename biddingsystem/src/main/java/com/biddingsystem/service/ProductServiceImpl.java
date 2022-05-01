package com.biddingsystem.service;



import com.biddingsystem.dto.ProductDto;
import com.biddingsystem.entity.Product;
import com.biddingsystem.entity.User;
import com.biddingsystem.repo.ProductRepo;
import com.biddingsystem.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
@Builder
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ProductDto save(ProductDto dto) throws Exception {

        Product product;
        User user;

        if (dto.getProduct_id() != null && dto.getProduct_id() != 0) {
            product = productRepo.findProductsById(dto.getProduct_id()); //from repo, created by programmer
        } else {
            product = new Product();
        }
        product.setProduct_id(dto.getProduct_id());
        product.setProduct_name(dto.getProduct_name());
        product.setProduct_description(dto.getProduct_description());

        user= userRepo.findUserById(dto.getUserId());

        product.setUser(user);

        productRepo.save(product); // repo takes entity
        return dto;
    }
}
