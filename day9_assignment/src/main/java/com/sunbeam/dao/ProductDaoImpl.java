package com.sunbeam.dao;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.sunbeam.Utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
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

	@Override
	public List<Product> getProductInSpecificRange(Double Min, Double Max, Category productCategory) {
		String jpql="select p from Product p where p.price between :minP and :maxP and p.category=:category";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class)
					.setParameter("minP", Min)
					.setParameter("maxP", Max)
					.setParameter("category", productCategory).getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return products;
	}

	@Override
	public String applyDiscount(Category category, double discount) {
		String msg = "Applying discount failed..!";
		String jpql = "update Product p set p.price = p.price - :discount where p.category = :category";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("category", category).setParameter("discount", discount)
					.executeUpdate();
			tx.commit();
			msg = "Applied discount to products - " + rows;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return msg;
	}

	@Override
	public String deleteByProductName(String productName) {
		String msg="Product delete failed..!";
		String jpql = "select p from Product p where p.productName=:productName";
		Product prod = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			prod = session.createQuery(jpql,Product.class).setParameter("productName", productName).getSingleResult();
			session.delete(prod);
			tx.commit();
			msg="Product deleted successfully";
		} catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public String purchaseProduct(Long id, Integer n) {
		String msg = "Product purchased failed..!";
		Product prod = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			prod=session.get(Product.class, id);
			if(prod.getAvailableQuantity()>=n) {
				prod.setAvailableQuantity(prod.getAvailableQuantity()-n);
				tx.commit();
				msg="Product purchased successsfully";
			}
			
		} catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	

	
	
	
	
	
}