package findshop.DaeguHaeng_backend.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "place_type") // 상속을 구분해줄 칼럼명
@Getter @Setter
public abstract class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long Id;

    private String name;
    private String address;
    private Double rate;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews = new ArrayList<Review>();





}
