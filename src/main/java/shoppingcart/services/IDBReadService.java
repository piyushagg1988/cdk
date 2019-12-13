package shoppingcart.services;


import shoppingcart.core.entity.Discount;

import java.util.List;

public interface IDBReadService {

    List<Discount> getAllDiscounts();

    Boolean addDiscountBucket(Discount discount);
}
