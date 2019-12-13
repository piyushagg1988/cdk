package shoppingcart.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import shoppingcart.ApplicationMain;
import shoppingcart.core.model.AddDiscountBucketRequest;
import shoppingcart.core.model.GetDiscountedPriceRequest;
import shoppingcart.core.model.GetDiscountedPriceResponse;

import java.awt.*;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
@WebAppConfiguration
public class ShoppingcartControllerIntegrationTest extends AbstractTest{



    @Test
    public void addDiscountsBucket() throws Exception {


        String uri = "/addDiscountsBucket";
        AddDiscountBucketRequest request = new AddDiscountBucketRequest();
        request.setDiscount(5.0);
        request.setDiscountStartPrice(0);
        request.setDiscountEndPrice(5000);
        String requestString = mapToJson(request);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).contentType("application/json").
                content(requestString)).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void getDiscountedPrice() throws Exception {
        String uri = "/getDiscountedPrice";
        GetDiscountedPriceRequest request = new GetDiscountedPriceRequest();
        request.setPrice(4000.0);
        String requestString = mapToJson(request);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).contentType("application/json").
                content(requestString)).andReturn();
        GetDiscountedPriceResponse response = mapFromJson(mvcResult.getResponse().getContentAsString(),GetDiscountedPriceResponse.class);
        assertEquals(3800.0,response.getFinalPrice(),0.0 );
    }

}
