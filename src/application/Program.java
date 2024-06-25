package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====\n");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====\n");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller sel : list) {
			System.out.println(sel);
		}
		System.out.println("\n==== TEST 3: seller findByDepartment ====\n");
		list = sellerDao.findAll();
		for(Seller sel : list) {
			System.out.println(sel);
		}
		
		//INSERE DADOS NA TABELA, PARA QUE FUNCIONE, RETIRE AS BARRAS DE COMENTÁRIO
		//System.out.println("\n==== TEST 4: seller insert ====\n");
		//Seller newSeller = new Seller(null, "Neias", "neias@gmail.com",
			//	LocalDate.parse("01/03/2006", dtf),4000.00, department);
		//sellerDao.insert(newSeller);
		//System.out.println("New Id: " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update ====\n");
		seller = sellerDao.findById(1);
		seller.setName("Neias Neias");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		System.out.println("\n==== TEST 6: seller delete ====\n");
		System.out.print("Enter an ID to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		sc.close();
		System.out.println("ID: "+ id +" deleted");
		
	}

}
