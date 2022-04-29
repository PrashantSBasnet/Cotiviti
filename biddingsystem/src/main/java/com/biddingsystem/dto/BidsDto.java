package com.biddingsystem.dto;

import com.biddingsystem.entity.Bids;
import com.biddingsystem.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidsDto {

    private Integer id;

    private String product_name;

    private String product_description;

    private String bid_status;

    private Integer userId;

    private Integer productId;

    public BidsDto (Bids entity) {
        this.setId(entity.getId());
       // this.setProduct_name(entity.getProduct_name());
        //this.setProduct_description(entity.getProduct_description());
        this.setBid_status(entity.getBid_status());
        this.setUserId(entity.getUsers().getId());
       // this.setProductId(entity.getProduct().getProduct_id());
    }



    public List<BidsDto> toDto(List<Bids> entityList) {
        List<BidsDto> dtoList = new ArrayList<>();
        for (Bids bids : entityList) {
            dtoList.add(new BidsDto(bids));
        }
        return dtoList;
    }
}
