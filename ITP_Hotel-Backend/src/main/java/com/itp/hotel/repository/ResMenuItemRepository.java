package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itp.hotel.model.ResMenuItem;

public interface ResMenuItemRepository extends JpaRepository<ResMenuItem,Long>{
	


	
   
	@Query(value = "SELECT * FROM res_menu_item  WHERE menu_item_type =?1",nativeQuery = true)
    List<ResMenuItem> searchQuery(String menuItemType);

}
