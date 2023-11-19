package peaksoft.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Task> task;


}
