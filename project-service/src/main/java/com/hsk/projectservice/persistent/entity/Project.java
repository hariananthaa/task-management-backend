package com.hsk.projectservice.persistent.entity;

import com.hsk.projectservice.persistent.entity.base.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Audited
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "project_seq",allocationSize = 1)
public class Project extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 8628587019149489711L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "project_seq")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String key;

    private String description;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), project.getId()) && Objects.equals(getName(), project.getName()) && Objects.equals(getKey(), project.getKey()) && Objects.equals(getDescription(), project.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName(), getKey(), getDescription());
    }
}
