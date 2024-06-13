package com.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.boot.MobileRepository.MobileRepo;
import com.boot.entity.Mobile;

@SpringBootApplication
public class SpringPaginationSortingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringPaginationSortingApplication.class, args);
        MobileRepo repo = context.getBean(MobileRepo.class);

        // Uncomment to save sample data
        /*
        Mobile mobile1 = new Mobile();
        mobile1.setName("Samsung");
        mobile1.setPrice(34000);

        Mobile mobile2 = new Mobile();
        mobile2.setName("OnePlus");
        mobile2.setPrice(7888);

        ArrayList<Mobile> list = new ArrayList<>();
        list.add(mobile1);
        list.add(mobile2);

        List<Mobile> saveAll = repo.saveAll(list);
        System.out.println("Saved successfully: " + saveAll);
        */
        
        // sorting asce

        // Sorting all mobiles by price in ascending order
        Sort sortAsc = Sort.by(Sort.Direction.ASC, "price");
        List<Mobile> allAsc = repo.findAll(sortAsc);

        allAsc.forEach(e -> {
            System.out.println(e);
        });

        System.out.println("+++++++++++++++++++++++++++++");
        
        // Sorting all mobiles by price in descending order
        Sort sortDesc = Sort.by(Sort.Direction.DESC, "price");
        List<Mobile> allDesc = repo.findAll(sortDesc);

        allDesc.forEach(e -> {
            System.out.println(e);
        });
        
        // Pagination Spring boot 
        System.out.println("++++++++++++++++++++++++++++");
        
        PageRequest request = PageRequest.of(1, 2);
        Page<Mobile> all = repo.findAll(request);
        
        all.forEach(e->{
        	System.out.println(e);
        });
        
        // Spring boot Pagination Shorting.....
        System.out.println("++++++++++++++++++++++++++++++++++++");
        
        PageRequest sortedPageRequest = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "price"));
        Page<Mobile> sortedPagedResult = repo.findAll(sortedPageRequest);

        sortedPagedResult.forEach(e -> {
            System.out.println(e);
        });
        
        //Spring boot Pagination Shorting......
        System.out.println("++++++++++++++++++++++++++++++++++");
        
        PageRequest of = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "price"));
        Page<Mobile> page = repo.findAll(of);
        
        page.forEach(e->{
        	System.out.println(e);
        });
        
    }
}
