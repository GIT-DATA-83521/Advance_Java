package com.sunbeam.dao;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.sunbeam.Utils.HibernateUtils.getFactory;

import java.io.Serializable;

import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao {
	@Override
	public String addProduct(Product product) {
		String msg="Product haven't added";
		Session session =getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable productId = session.save(product);
			tx.commit();
			msg="Product added successfully..!";
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		Product product=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			product=session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}
}