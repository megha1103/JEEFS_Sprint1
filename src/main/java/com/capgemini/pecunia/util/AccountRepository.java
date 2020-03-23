package com.capgemini.pecunia.util;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.pecunia.dto.*;
public class AccountRepository 
{
	 public static List<Slip> detailsList = new ArrayList<Slip>();
	 public AccountRepository()
	 {	
	 detailsList.add(new Slip("653578966468",2000));
	 detailsList.add(new Slip("767537807532",5000));
	 detailsList.add(new Slip("166785478509",6000));
	 detailsList.add(new Slip("653789178509",2100));
	 detailsList.add(new Slip("654367975356",8000));
	 detailsList.add(new Slip("645382024465",6000));
	 detailsList.add(new Slip("756483901355",5000));
	 detailsList.add(new Slip("154759302323",8000));
	 detailsList.add(new Slip("093421567450",8000));
	 detailsList.add(new Slip("154750006323",80));
	 }
	public static List<Slip> getDetailsList() {
		return detailsList;
	}
	
	public static void setDetailsList(List<Slip> detailsList) {
		AccountRepository.detailsList = detailsList;
	}
	
} 

/*
public Slip getAccountById( String AccountId)
{
Slip result1 =detailsList.stream()                        
.filter(x ->AccountId.equals(x.getAccountNo()))        
.findAny()                                  
.orElse(null);                                  
return result1;
}

*/

/*
 * public String getAccountById( String AccountId)
{
	 
     	
     	 
     	 String id = detailsList.stream()
                 .filter(x -> AccountId.equals(x.getAccountNo()))
                 .map(Slip::getAccountNo)                     
                 .findAny()
                 .orElse("");
     	 return id;
         	
}
 *  
 *  
 *  
 *  
 *  TransactionUtil obj=new TransactionUtil();

System.out.println(obj.getAccountById( "166785478509"));


Slip max = detailsList.stream()
			.collect(Collectors.maxBy(
				Comparator.comparing(Slip::getAmount)))
			.get();
*/