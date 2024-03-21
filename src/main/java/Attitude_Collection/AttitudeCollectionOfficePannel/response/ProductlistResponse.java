package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Subcategory;
import lombok.Builder;

import java.util.List;


@Builder
public class ProductlistResponse {
    public List<Category> categoryList;
   public  List<Subcategory> subcategoryList;
}
