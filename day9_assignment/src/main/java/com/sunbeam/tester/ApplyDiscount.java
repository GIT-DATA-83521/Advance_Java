package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.Utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class ApplyDiscount {
public static void main(String[] args) {
	try(SessionFactory sf = getFactory();
			Scanner sc = new Scanner(System.in)) {
		ProductDao dao = new ProductDaoImpl();
		System.out.println("Enter category and discount amount to be applied");
		System.out.println(dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()), sc.nextDouble()));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
