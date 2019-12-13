package shoppingcart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingcart.core.entity.Discount;
import shoppingcart.dao.IDiscountsDao;
import shoppingcart.services.IDBReadService;

import java.util.List;

@Service
public class DBReadServiceImpl implements IDBReadService {

    @Autowired
    IDiscountsDao discountsDao;

    public List<Discount> getAllDiscounts() {
        return  discountsDao.getAllDiscounts();
    }

    @Transactional()
    public Boolean addDiscountBucket(Discount discount) {
        return discountsDao.addDiscountBucket(discount);
    }


}
