package effective.mobile.task_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "tasks")
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    @Enumerated(value = EnumType.STRING)
    private TaskPriority taskPriority;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntities;

    @ManyToOne
    @JoinColumn(name = "user_id_author")
    private UserEntity userEntityAuthor;

    @ManyToOne
    @JoinColumn(name = "user_id_executor")
    private UserEntity userEntityExecutor;

}
