//SENARYO 
//    Kahve dükkanlarý için müþteri yönetimi yapan bir sistem yazmak istiyoruz.
//    Starbucks ve Nero firmasý için çalýþýyoruz.
//    Ýki firma da müþterilerini veritabanýna kaydetmek istiyor.(Ýkisininde veritabanýna ekleme kodlarý ayný)
//    Starbucks müþterileri kaydederken,mutlaka mernis doðrulamasý istiyor. (https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula)
//    Nero müþterileri kaydederken böyle bir þey istemiyor.


import java.time.LocalDate;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		BaseCustomerManager customerManagerStarbucks = new StarbucksCustomerManager(new MernisServiceAdapter()); 
		BaseCustomerManager customerManagerNero = new NeroCustomerManager(new CustomerCheckManager()); //Bir zaman sonra Neroda MernisDoðrulama isterse diðer kodlara hiç dokunmadan ekleyebiliriz.
																									   //new MernisServiceAdapter()
		Customer customerStarbucks = new Customer();
		customerStarbucks.setId(1);;
		customerStarbucks.setFirstName("Eray");
		customerStarbucks.setLastName("Ögeter");
		customerStarbucks.setNationalityId("11223334455");
		customerStarbucks.setDateOfBirth(LocalDate.of(1998, 3, 17));
		customerManagerStarbucks.save(customerStarbucks);
		
		System.out.println("-----------------------------------------------------------------");
		
		Customer customerNero = new Customer();
		customerNero.setId(1);
		customerNero.setFirstName("Kerem");
		customerNero.setLastName("Altay");
		customerNero.setNationalityId("99887776655");
		customerNero.setDateOfBirth(LocalDate.of(2005,11,18));
		customerManagerNero.save(customerNero);
	}

}