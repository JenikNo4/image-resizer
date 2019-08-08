package cz.simek.codelib.imageresizer.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class ImageResizerService {


    public BufferedImage resize(BufferedImage bufferedImage) {

        BufferedImage scaledImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(bufferedImage, 0, 0, 640, 480, null);
        graphics2D.dispose();
        return scaledImage;

    }

}
