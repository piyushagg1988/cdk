package shoppingcart.dao;

import shoppingcart.core.entity.Discount;

import java.util.List;

public interface IDiscountsDao {
    List<Discount> getAllDiscounts();

    Boolean addDiscountBucket(Discount discount);
}
