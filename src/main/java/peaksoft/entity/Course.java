package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @OneToMany(mappedBy = "courses")
    private List<Group> group;
    @OneToMany(mappedBy = "courses")
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "courses")
    private List<Lesson> lessons;
}
