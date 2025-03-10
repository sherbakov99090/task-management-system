package effective.mobile.task_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @Enumerated(value = EnumType.STRING)
    private TaskPriority taskPriority;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "user_id_author")
    private User userAuthor;

    @ManyToOne
    @JoinColumn(name = "user_id_executor")
    private User userExecutor;

}
