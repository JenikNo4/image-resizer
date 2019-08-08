package cz.simek.codelib.imageresizer.controller;

import cz.simek.codelib.imageresizer.service.ImageResizerService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ImageResizerService imageResizerService;

    @RequestMapping(value = "/index")
    public String indexIndex() {
        log.info("/index");
        return "index";
    }

    @SneakyThrows
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpServletResponse response) {

        BufferedImage resize = imageResizerService.resize(ImageIO.read(file.getInputStream()));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(resize, "jpg", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.set("test", "test");
        headers.setContentDispositionFormData(file.getName(), file.getOriginalFilename());
        response.setContentType("application/text");
        response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
        IOUtils.copy(is, response.getOutputStream());
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }
}
