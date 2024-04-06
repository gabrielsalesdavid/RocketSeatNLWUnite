package rocketseat.com.pass.in.domain.checkin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rocketseat.com.pass.in.domain.attendee.Attendee;

import java.time.LocalDateTime;

@Entity
@Table(name = "check_in")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;
}