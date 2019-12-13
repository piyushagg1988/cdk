package shoppingcart.core.dto;


import shoppingcart.core.entity.Discount;

import java.util.List;

public class GetAllDiscounts {

    private List<Discount> discountList;

    public GetAllDiscounts(List<Discount> discountList) {
        this.discountList = discountList;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }

    @Override
    public String toString() {
        return "GetAllDiscounts{" + "discountList=" + discountList + '}';
    }
}
