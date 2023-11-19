package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Group> group;
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<Lesson> lesson;
    @ManyToOne
    private Company company;
    @OneToMany(mappedBy = "course")
    private List<Instructor> instructors;


}
