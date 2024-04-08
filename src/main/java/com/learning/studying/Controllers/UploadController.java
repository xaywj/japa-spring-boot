package com.learning.studying.Controllers;
import com.learning.studying.Models.Upload;
import com.learning.studying.Services.Upload.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/upload")
public class UploadController {
    private final UploadService uploadService;
    private static String UPLOAD_FOLDER = "uploads/";

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "Please select a file to upload";
        }
        try {
            String originalFilename = file.getOriginalFilename();
            String fileExtension = StringUtils.getFilenameExtension(originalFilename);

            String fileName = UUID.randomUUID().toString() + "." + fileExtension;

            // Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(UPLOAD_FOLDER));

            // Save the uploaded file with the custom filename to the custom folder
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + fileName);
            Files.write(path, bytes);

            return "Upload success. File extension: " + fileExtension;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Upload success";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping()
    public List<Upload> all(){
        return this.uploadService.All();
    }
    @PostMapping()
    public Upload create(Upload upload){
        return this.uploadService.create(upload);
    }
    @PutMapping("{id}")
    public Upload update(@PathVariable long id, Upload upload){
        return this.uploadService.update(upload, id);
    }
    @GetMapping("{id}")
    public Upload view(@PathVariable Long id){
        return this.uploadService.getById(id);
    }
    @DeleteMapping()
    public String delete(@PathVariable Long id){
        return this.uploadService.delete(id);
    }
}
