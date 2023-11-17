package peaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lessonName;
    @OneToOne
    private Course course;
    @OneToMany
    private List<Task> task;

}
