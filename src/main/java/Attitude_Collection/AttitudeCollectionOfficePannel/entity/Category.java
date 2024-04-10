package Attitude_Collection.AttitudeCollectionOfficePannel.entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String categoryName;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Subcategory> subcategoryList = new ArrayList<>();


}
