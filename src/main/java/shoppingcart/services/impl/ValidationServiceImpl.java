package shoppingcart.services.impl;

import org.springframework.stereotype.Service;
import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.GetDiscountedPriceRequest;
import shoppingcart.services.IValidationService;

@Service
public class ValidationServiceImpl implements IValidationService {

    public void validateRequest(GetDiscountedPriceRequest request) {
        checkIfNull(request);
        checkIfNull(request.getPrice());
        checkIfDoubleValueLessThanZero(request.getPrice());
    }

    public void validateRequest(AddDiscountBucketRequest request) {
        checkIfNull(request);
        checkIfDoubleValueLessThanZero(request.getDiscount());
        checkIfIntegerValueLessThanZero(request.getDiscountEndPrice());
        checkIfIntegerValueLessThanZero(request.getDiscountStartPrice());
    }

    private void checkIfIntegerValueLessThanZero(int value) {
        if (value<0) {
            throw new NullPointerException();
        }
    }

    private void checkIfNull(Object o) {
        if (null == o) {
            throw new NullPointerException();
        }
    }

    private void checkIfDoubleValueLessThanZero(Double value) {
        if(value<0){
            throw new NumberFormatException();
        }
    }


}
