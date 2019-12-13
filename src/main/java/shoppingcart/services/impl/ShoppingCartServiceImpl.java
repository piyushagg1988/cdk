package shoppingcart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingcart.core.entity.Discount;
import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.AddDiscountBucketResponse;
import shoppingcart.core.model.GetDiscountedPriceResponse;
import shoppingcart.services.IDBReadService;
import shoppingcart.services.IShoppingCartService;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    @Autowired
    IDBReadService dbReadService;

    private List<Discount> getAllDiscounts() {
        List<Discount> discountList = dbReadService.getAllDiscounts();
        return discountList;

    }

    public GetDiscountedPriceResponse getDiscountedPrice(Double price) {
        GetDiscountedPriceResponse response = new GetDiscountedPriceResponse();
       List<Discount> discounts = getAllDiscounts();
        for (Discount discount:discounts) {
            if(discount.getDiscountStartPrice()<=price && discount.getDiscountEndPrice()>=price){
                price= price-(price*(discount.getDiscount()/100));
            }
        }
        response.setFinalPrice(price);
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    public AddDiscountBucketResponse addDiscountBucket(AddDiscountBucketRequest request){
        AddDiscountBucketResponse response = new AddDiscountBucketResponse();

        Date date = new Date();
        Discount discount = new Discount(request.getDiscount(),request.getDiscountStartPrice(),request.getDiscountEndPrice(),date,(byte)1);

        response.setStatus(dbReadService.addDiscountBucket(discount));
        return response;
    }
}
