import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
@Getter
@Setter
public class Course implements Serializable {

    private enum CourseType {
        DESIGN,
        PROGRAMMING,
        MARKETING,
        MANAGEMENT,
        BUSINESS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

//    @Column(name = "teacher_id")
//    private int teacherId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    List<Subscription> subscriptions;
}
