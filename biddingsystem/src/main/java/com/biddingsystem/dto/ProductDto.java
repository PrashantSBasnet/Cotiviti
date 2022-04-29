package com.biddingsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    public Integer product_id;

    public String product_name;

    public String product_description;

    public Integer userId;

}
