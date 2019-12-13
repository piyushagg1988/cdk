package shoppingcart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.AddDiscountBucketResponse;
import shoppingcart.core.model.GetDiscountedPriceRequest;
import shoppingcart.core.model.GetDiscountedPriceResponse;
import shoppingcart.services.IShoppingCartService;
import shoppingcart.services.IValidationService;

@Controller
public class ShippingCartController {

    @Autowired
    private IShoppingCartService shippingCartService;

    @Autowired
    private IValidationService validationService;

    @RequestMapping(value = "/getDiscountedPrice")
    @ResponseBody
    public GetDiscountedPriceResponse getDiscountedPrice(@RequestBody GetDiscountedPriceRequest request){
        validationService.validateRequest(request);
        return shippingCartService.getDiscountedPrice(request.getPrice());

    }

    @RequestMapping(value = "/addDiscountsBucket",consumes = "application/json", produces = "application/json")
    @ResponseBody
    public AddDiscountBucketResponse addDiscountsBucket(@RequestBody AddDiscountBucketRequest request){
        validationService.validateRequest(request);
        return shippingCartService.addDiscountBucket(request);

    }


}
