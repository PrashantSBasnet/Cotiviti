package com.biddingsystem.dto;

import com.biddingsystem.entity.Bids;
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

//    private String product_name;
//
//    private String product_description;

    private String bid_status;

    private Boolean isSettled;

    private Integer userId;

    private String productName;

    //private Integer productId;

    private Double biddingRate;

    public BidsDto (Bids entity) {
        this.setId(entity.getId());
        this.setIsSettled(entity.getIsSettled());
        this.setBid_status(entity.getBid_status());
        this.setUserId(entity.getUsers().getId());
        //this.setProductId(entity.getProduct().getProduct_id());
        this.setProductName(entity.getProduct().getProduct_name());
        this.setBiddingRate(entity.getBiddingRate());
    }



    public List<BidsDto> toDto(List<Bids> entityList) {
        List<BidsDto> dtoList = new ArrayList<>();
        for (Bids bids : entityList) {
            dtoList.add(new BidsDto(bids));
        }
        return dtoList;
    }
}
