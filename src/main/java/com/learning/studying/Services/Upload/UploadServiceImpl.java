package com.learning.studying.Services.Upload;
import com.learning.studying.Models.Upload;
import com.learning.studying.Repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UploadServiceImpl implements UploadService{
    private final UploadRepository uploadRepository;

    @Autowired
    public UploadServiceImpl(UploadRepository uploadRepository) {
        this.uploadRepository =  uploadRepository;
    }

    @Override
    public List<Upload> All() {
        return uploadRepository.findAll();
    }

    @Override
    public Upload create(Upload upload) {
        return uploadRepository.save(upload);
    }

    @Override
    public Upload getById(Long id) {
        return uploadRepository.findById(id).orElse(null);
    }

    @Override
    public Upload update(Upload upload, Long id) {
        Optional<Upload> optionalUpload = uploadRepository.findById(id);
        if(optionalUpload.isPresent()){
            Upload exitUpload=optionalUpload.get();
            exitUpload.setFileName(upload.getFileName());
            exitUpload.setFilePath(upload.getFilePath());
            return uploadRepository.save(exitUpload);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Optional<Upload> optionUpload = uploadRepository.findById(id);
        if (optionUpload.isPresent()) {
            uploadRepository.deleteById(id);
            return "delete success this id: " + id;
        } else {
            return "Failed delete ID:" + id;
        }
    }
}
