package com.hsk.projectservice.persistent.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hsk.projectservice.persistent.entity.base.BaseEntity;
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

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "project_key_fk",
            referencedColumnName = "key",
            nullable = false,
            foreignKey = @ForeignKey(name = "PROJECT_KEY_FK")
    )
    @JsonProperty("project_key_fk")
    private Project project;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String priority;

    @JsonProperty("due_date")
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), task.getId()) && Objects.equals(getProject(), task.getProject()) && Objects.equals(getTitle(), task.getTitle()) && Objects.equals(getDescription(), task.getDescription()) && Objects.equals(getStatus(), task.getStatus()) && Objects.equals(getPriority(), task.getPriority()) && Objects.equals(getDueDate(), task.getDueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getProject(), getTitle(), getDescription(), getStatus(), getPriority(), getDueDate());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", projectId=" + project +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
