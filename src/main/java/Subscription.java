import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class SubscriptionKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}


@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public class Subscription {

    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;
}
