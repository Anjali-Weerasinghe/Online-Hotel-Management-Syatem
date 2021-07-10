package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.MenuItemCategory;

public interface ItemCategoryRepository extends JpaRepository<MenuItemCategory, Long> {

}
