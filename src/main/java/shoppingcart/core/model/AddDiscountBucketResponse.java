package shoppingcart.core.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class AddDiscountBucketResponse {

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddDiscountBucketResponse{" + "status=" + status + '}';
    }
}
