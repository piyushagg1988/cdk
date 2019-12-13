package shoppingcart.controller;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shoppingcart.core.entity.Discount;
import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.GetDiscountedPriceRequest;
import shoppingcart.core.model.GetDiscountedPriceResponse;
import shoppingcart.services.IDBReadService;
import shoppingcart.services.IShoppingCartService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(ShippingCartController.class)
public class ShoppingcartControllerTest extends AbstractTest{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataSource dataSource;
    @MockBean
    private SessionFactory factory;

    @MockBean
    private IShoppingCartService cartService;

    @MockBean
    private IDBReadService dbReadService;

    public void setUp()
    {

    }
    @Test
    public void getShoppingDiscountTest() throws Exception
    {
        Discount discount = new Discount();
        discount.setDiscount(5);
        discount.setDiscountEndPrice(5000);
        discount.setDiscountStartPrice(1000);
        List<Discount> discounts = new ArrayList();
        discounts.add(discount);
        BDDMockito.given(dbReadService.getAllDiscounts()).willReturn(discounts);
        GetDiscountedPriceRequest  discountedPriceRequest = new GetDiscountedPriceRequest();
        discountedPriceRequest.setPrice(4000.0);

        GetDiscountedPriceResponse response = new GetDiscountedPriceResponse();
        response.setFinalPrice(3800.0);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/getDiscountedPrice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(discountedPriceRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void addDiscountBucketTest() throws Exception
    {

        Discount discount = new Discount();
        discount.setDiscount(5);
        discount.setDiscountEndPrice(5000);
        discount.setDiscountStartPrice(1000);
        AddDiscountBucketRequest request = new AddDiscountBucketRequest();
        request.setDiscountStartPrice(discount.getDiscountStartPrice());
        request.setDiscountEndPrice(discount.getDiscountEndPrice());
        request.setDiscount(discount.getDiscount());
        BDDMockito.given(dbReadService.addDiscountBucket(discount)).willReturn(true);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/addDiscountsBucket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(request))).andExpect(MockMvcResultMatchers.status().isOk());

    }
}

