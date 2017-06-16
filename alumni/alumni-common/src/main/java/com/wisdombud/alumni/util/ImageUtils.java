package com.wisdombud.alumni.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class ImageUtils {
    /**
     * scale image
     * @param sbi image to scale
     * @param imageType type of image
     * @param dWidth width of destination image
     * @param dHeight height of destination image
     * @param fWidth x-factor for transformation / scaling
     * @param fHeight y-factor for transformation / scaling
     * @return scaled image
     */
    public static BufferedImage scale(BufferedImage sbi) {
        BufferedImage ret = sbi;
        BufferedImage scratchImage = ImageUtils.decideSize(sbi);
        Graphics2D g2 = null;

        int w = sbi.getWidth();
        int h = sbi.getHeight();

        int targetW = scratchImage.getWidth();
        int targetH = scratchImage.getHeight();

        g2 = scratchImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(ret, 0, 0, targetW, targetH, 0, 0, w, h, null);

        if (g2 != null) {
            g2.dispose();
        }
        return scratchImage;
    }

    /**
     * 保证图片的最大宽度不大于500.
     * @param img
     * @return
     */
    public static BufferedImage decideSize(BufferedImage img) {
        final int maxWidth = 500;
        final int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB;
        int w = img.getWidth();
        int h = img.getHeight();

        int targetWidth = w;
        int targetHeight = h;

        // 宽度大于600
        if (w > maxWidth) {
            float whratio = (float) w / (float) maxWidth;
            targetWidth = maxWidth;
            targetHeight = (int) Math.floor(h / whratio);
        }

        return new BufferedImage(targetWidth, targetHeight, type);
    }

    public static BufferedImage scale(BufferedImage img, int targetWidth, int targetHeight) {
        int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = img;
        BufferedImage scratchImage = null;
        Graphics2D g2 = null;

        int w = img.getWidth();
        int h = img.getHeight();

        if (w <= targetWidth || h <= targetHeight) {
            return ret;
        }

        int prevW = w;
        int prevH = h;

        do {
            if (w > targetWidth) {
                w /= 2;
                w = (w < targetWidth) ? targetWidth : w;
            }

            if (h > targetHeight) {
                h /= 2;
                h = (h < targetHeight) ? targetHeight : h;
            }

            if (scratchImage == null) {
                scratchImage = new BufferedImage(w, h, type);
                g2 = scratchImage.createGraphics();
            }

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(ret, 0, 0, w, h, 0, 0, prevW, prevH, null);

            prevW = w;
            prevH = h;
            ret = scratchImage;
        } while (w != targetWidth || h != targetHeight);

        if (g2 != null) {
            g2.dispose();
        }

        if (targetWidth != ret.getWidth() || targetHeight != ret.getHeight()) {
            scratchImage = new BufferedImage(targetWidth, targetHeight, type);
            g2 = scratchImage.createGraphics();
            g2.drawImage(ret, 0, 0, null);
            g2.dispose();
            ret = scratchImage;
        }

        return ret;

    }

    public static void main(String[] args) {
        int w = 920;
        int h = 590;
        float whratio = (float) w / (float) 600;
        System.out.println("targetHeight = " + (int) Math.floor(h / whratio));
    }
}
