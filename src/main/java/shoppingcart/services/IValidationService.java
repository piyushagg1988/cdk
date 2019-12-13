package shoppingcart.services;

import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.GetDiscountedPriceRequest;

public interface IValidationService {
    void validateRequest(GetDiscountedPriceRequest request);

    void validateRequest(AddDiscountBucketRequest request);
}
