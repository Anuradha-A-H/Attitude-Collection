package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory,Integer> {

    List<Subcategory> findSubcategoryByCategory(Category cat);
}
