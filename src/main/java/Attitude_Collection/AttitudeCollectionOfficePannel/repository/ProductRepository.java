package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,String> {
}
