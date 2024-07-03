package com.sunbeam.tester;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import static com.sunbeam.Utils.HibernateUtils.getFactory;

public class GetProductDetailsInSpecficRange {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter min and max price and category");
			dao.getProductInSpecificRange(sc.nextDouble(), sc.nextDouble(), Category.valueOf(sc.next().toUpperCase()))
					.forEach(s->{System.out.println(s);});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
