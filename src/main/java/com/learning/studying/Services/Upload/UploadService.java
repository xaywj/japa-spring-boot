package com.learning.studying.Services.Upload;

import com.learning.studying.Models.Upload;

import java.util.List;

public interface UploadService {
    public List<Upload> All();
    public Upload create(Upload upload);
    public Upload getById(Long id);
    public Upload update(Upload upload, Long id);
    public String delete(Long id);

}
