package com.sunbeam.tester;

import static com.sunbeam.Utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;



public class DeleteProduct {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Product name for deleting the Product");
			System.out.println(dao.deleteByProductName(sc.next()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
