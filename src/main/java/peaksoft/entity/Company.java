package peaksoft.entity;
import jakarta.persistence.*;
import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Entity
@Table(name = "companies")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String  locatedCountry;
    private String image;
    @OneToMany(mappedBy = "company")
    private List<Course> course;
    @OneToMany
    private List<Instructor> instructors;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Group> groups;


}
