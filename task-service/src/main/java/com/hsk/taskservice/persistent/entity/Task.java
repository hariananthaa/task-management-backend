package com.hsk.taskservice.persistent.entity;

import com.hsk.taskservice.persistent.entity.base.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "task")
@Audited
@SequenceGenerator(name = "task_seq",allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class Task extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -8071844719998898018L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_seq")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String priority;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), task.getId()) && Objects.equals(getTitle(), task.getTitle()) && Objects.equals(getDescription(), task.getDescription()) && Objects.equals(getStatus(), task.getStatus()) && Objects.equals(getPriority(), task.getPriority()) && Objects.equals(getDueDate(), task.getDueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getTitle(), getDescription(), getStatus(), getPriority(), getDueDate());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
