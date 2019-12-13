package shoppingcart.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="discounts")
public class Discount {



    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int                       id;
    @Column(name = "discount")
    private double                    discount;
    @Column(name = "discount_start_price")
    private int                       discountStartPrice;
    @Column(name = "discount_end_price")
    private int                       discountEndPrice;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19, updatable = false)
    private Date created;
    @Column(name = "enabled", length = 19, updatable = false)
    private byte                   enabled;

    public Discount() {
    }

    public Discount(double discount, int discountStartPrice, int discountEndPrice, Date created, byte enabled) {
        this.discount = discount;
        this.discountStartPrice = discountStartPrice;
        this.discountEndPrice = discountEndPrice;
        this.created = created;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
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


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return "Discount{" + "id=" + id + ", discount=" + discount + ", discountStartPrice=" + discountStartPrice + ", discountEndPrice=" + discountEndPrice + ", created=" + created + ", enabled=" + enabled + '}';
    }
}
