package com.wellsfargo.training.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.ims.model.Product;

//JpaRepository<Model Class name, Data type of primary field>

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	 /*
     * This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       This interface will be implemented by class automatically
    */

}
