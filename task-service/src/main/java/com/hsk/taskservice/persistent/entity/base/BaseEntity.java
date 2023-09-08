package com.hsk.taskservice.persistent.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false,updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(nullable = false)
    private String updatedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Version
    private Long version;

    private Boolean deleted;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity that)) return false;
        return Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getCreatedBy(), that.getCreatedBy()) && Objects.equals(getUpdatedBy(), that.getUpdatedBy()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getDeleted(), that.getDeleted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreatedAt(), getCreatedBy(), getUpdatedBy(), getUpdatedAt(), getVersion(), getDeleted());
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
