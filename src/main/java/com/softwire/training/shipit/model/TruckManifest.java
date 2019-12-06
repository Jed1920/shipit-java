package com.softwire.training.shipit.model;

import com.softwire.training.shipit.dao.ProductDAO;

import java.util.List;

public class TruckManifest {

    private Float totalWeight;
    private List<Product> productList;

    public TruckManifest(OutboundOrder outboundOrder, ProductDAO productDAO){

        for(OrderLine orderline : outboundOrder.getOrderLines()){

            String gtin = orderline.getGtin();
            Product product = productDAO.getProductByGtin(gtin);
            productList.add(product);

            float weight = product.getWeight();
            totalWeight += weight;

        }

    }
}
