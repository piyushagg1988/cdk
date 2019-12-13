package shoppingcart.core.model;

public class AddDiscountBucketRequest {

    private Double discount;
    private int discountStartPrice;
    private int discountEndPrice;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getDiscountStartPrice() {
        return discountStartPrice;
    }

    public void setDiscountStartPrice(int discountStartPrice) {
        this.discountStartPrice = discountStartPrice;
    }

    public int getDiscountEndPrice() {
        return discountEndPrice;
    }

    public void setDiscountEndPrice(int discountEndPrice) {
        this.discountEndPrice = discountEndPrice;
    }

    @Override
    public String toString() {
        return "AddDiscountBucketRequest{" + "discount=" + discount + ", discountStartPrice=" + discountStartPrice + ", discountEndPrice=" + discountEndPrice + '}';
    }
}
