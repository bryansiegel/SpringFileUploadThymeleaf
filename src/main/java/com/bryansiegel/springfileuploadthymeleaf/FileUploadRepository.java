package com.bryansiegel.springfileuploadthymeleaf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileModel, Long> {
}
