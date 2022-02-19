package com.vti.frontend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.Utils.ScannerUltis;

public class DemoHQL {
	public static void main(String[] args) {

		AccountRepository accountRepository = new AccountRepository();
		/*List<Account> list = accountRepository.getAllAccount();
		for (Account account : list) {
			System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
					+ account.getUsername() + " FullName: " + account.getFullname() + " Department: "
					+ account.getDepartment().getName() + " Possition: " + account.getPosition().getPositionName());
		}*/

//		System.out.println("Nhập vào ID của Account cần tìm kiếm: ");
//		int id = ScannerUltis.inputIntPositive();
//		Account account = accountRepository.get_ByID((short) id);
//		System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
//				+ account.getUsername() + " FullName: " + account.getFullname() + " Department: "
//				+ account.getDepartment().getName() + " Possition: " + account.getPosition().getName());

//		System.out.println("Nhập vào ID của Account cần tìm kiếm: ");
//		int id = ScannerUltis.inputIntPositive();
//		String fullname = accountRepository.get_FullName((short) id);
//		System.out.println("Fullname là: "+ fullname);

//		System.out.println("Thông tin User được tạo trong tháng hiện tại.");
//		List<Account> list = accountRepository.get_ByCurrentMonth();
//		for (Account account : list) {
//			System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
//					+ account.getUsername() + " FullName: " + account.getFullname() + " Department: "
//					+ account.getDepartment().getName() + " Possition: " + account.getPosition().getName());
//		}

//		System.out.println("Thông tin User được tạo trong tháng hiện tại.");
//		List<Account> list = accountRepository.get_ByCurrentMonthOderBy();
//		for (Account account : list) {
//			System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
//					+ account.getUsername() + " FullName: " + account.getFullname() + " Department: "
//					+ account.getDepartment().getName() + " Possition: " + account.getPosition().getName()
//					+ " CreateDate: " + account.getCreateDate());
//		}

		System.out.println("Thông tin số lượng Account được tạo theo các tháng.");
		List<Object[]> list = accountRepository.getAccountByMonthInYearCurrent();
//		Lặp các Array trong List sau đó in ra thông tin các phần tử mảng theo Index
		for (Object[] object : list) {
			System.out.println("Month: " + object[0] + "Count: " + object[1]);
		}

//		System.out.println("Tìm tháng có số lượng Account được tạo >2.");
//		List<Object[]> list = accountRepository.get_CountAccByMonthInYearCurrentgt2();
////		Lặp các Array trong List sau đó in ra thông tin các phần tử mảng theo Index
//		for (Object[] object : list) {
//			System.out.println("Month: " + object[0] + "Count: " + object[1]);
//		}

//		System.out.println("Nhập vào ID cần Update: ");
//		int id = ScannerUltis.inputIntPositive();
//		System.out.println("Nhập vào NewEmail: ");
//		String email = ScannerUltis.inputEmail();
//		System.out.println("Nhập vào NewUsername: ");
//		String username = ScannerUltis.inputString();
//		
//		accountRepository.updateEmailUsernameAccountByID(email, username, (short) id);

//		System.out.println("Nhập vào email cần xóa: ");
//		String email = ScannerUltis.inputEmail();
//		accountRepository.deleteAccount(email);

//		System.out.println("Demo Phân trang với Hibernate: ");
//		List<Account> list = accountRepository.get_AccountByPaging();
//		for (Account account : list) {
//			System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
//					+ account.getUsername() + " FullName: " + account.getFullname() + " Department: "
//					+ account.getDepartment().getName() + " Possition: " + account.getPosition().getName());
//		}
	}
}

