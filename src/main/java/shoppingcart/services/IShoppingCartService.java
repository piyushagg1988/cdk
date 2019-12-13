package shoppingcart.services;


import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.AddDiscountBucketResponse;
import shoppingcart.core.model.GetDiscountedPriceResponse;

public interface IShoppingCartService {

    GetDiscountedPriceResponse getDiscountedPrice(Double price);

    AddDiscountBucketResponse addDiscountBucket(AddDiscountBucketRequest request);
}
