package shoppingcart.core.model;

public class GetDiscountedPriceResponse {

    private Double finalPrice;

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "GetDiscountedPriceResponse{" + "finalPrice=" + finalPrice + '}';
    }
}
