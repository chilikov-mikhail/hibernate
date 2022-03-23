import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}


@Entity
@Table
@Getter
@Setter
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
}
