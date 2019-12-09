package com.softwire.training.shipit.model;

import com.softwire.training.shipit.dao.ProductDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckManifest {

    private List<Map<String, Integer>> TruckManifest;
    private final float maxTruckLoad = 2000000;
    private Map<String, Integer> productsToBeAllocatedTruck;


    public List<Map<String, Integer>> TruckManifest(List<OrderedProduct> orderedProducts){

        for (OrderedProduct orderedProduct : orderedProducts){
            Map<String, Integer> truck =new HashMap<String, Integer>();

            float weight = orderedProduct.getProductWeight();
            int quantity = orderedProduct.getQuantity();
            
            float totalProductWeightGrams = weight * quantity;

            if(totalProductWeightGrams == maxTruckLoad) {
                truck.put(orderedProduct.getGtin(),quantity);

            } else if(totalProductWeightGrams > maxTruckLoad){
                while(totalProductWeightGrams > maxTruckLoad) {
                    int truckQuantity = (int) (maxTruckLoad / weight);
                    truck.put(orderedProduct.getGtin(), truckQuantity);

                    totalProductWeightGrams = weight * (quantity - truckQuantity);
                }
            } else {

            }


        }




        return TruckManifest;
    }
}
