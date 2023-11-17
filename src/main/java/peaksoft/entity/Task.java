package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate deadline;
    @OneToOne(mappedBy = "tasks")
    private Lesson lesson;
}





