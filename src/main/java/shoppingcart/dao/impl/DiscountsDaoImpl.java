package shoppingcart.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shoppingcart.core.entity.Discount;
import shoppingcart.dao.IDiscountsDao;

import java.util.List;

@Repository
public class DiscountsDaoImpl implements IDiscountsDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Discount> getAllDiscounts(){
        Query query = sessionFactory.getCurrentSession().createQuery("from Discount group by discountStartPrice,discountEndPrice");
        return query.list();
    }

    public Boolean addDiscountBucket(Discount discount){
        Integer integer =  (Integer) sessionFactory.getCurrentSession().save(discount);
        return integer >0;
    }



}
