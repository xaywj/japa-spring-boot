package com.learning.studying.Repository;

import com.learning.studying.Models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {
 }
