package com.iweb.o2o.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.imageio.ImageIO;

public class ImageUtil {
  private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
  public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
    String realFileName = FileUtil.getRandomFileName();
    String extension = getFileExtension(thumbnail);
    makeDirPath(targetAddr);
    String relativeAddr = targetAddr + realFileName + extension;
    File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
    try {
     Thumbnails.of(thumbnail.getInputStream()).size(200, 200).
         watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
         .outputQuality(0.8f).toFile(dest);
    } catch (IOException e) {
     throw new RuntimeException("创建缩略图失败：" + e.toString());
    }
    return relativeAddr;
  }

  public static String generateNormalImg(CommonsMultipartFile thumbnail, String targetAddr) {
    String realFileName = FileUtil.getRandomFileName();
    String extension = getFileExtension(thumbnail);
    makeDirPath(targetAddr);
    String relativeAddr = targetAddr + realFileName + extension;
    File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
    try {
     Thumbnails.of(thumbnail.getInputStream()).size(337, 640).outputQuality(0.5f).toFile(dest);
    } catch (IOException e) {
     throw new RuntimeException("创建缩略图失败：" + e.toString());
    }
    return relativeAddr;
  }

  public static List<String> generateNormalImgs(List<CommonsMultipartFile> imgs, String targetAddr) {
    int count = 0;
    List<String> relativeAddrList = new ArrayList<String>();
    if (imgs != null && imgs.size() > 0) {
     makeDirPath(targetAddr);
     for (CommonsMultipartFile img : imgs) {
       String realFileName = FileUtil.getRandomFileName();
       String extension = getFileExtension(img);
       String relativeAddr = targetAddr + realFileName + count + extension;
       File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
       count++;
       try {
         Thumbnails.of(img.getInputStream()).size(600, 300).outputQuality(0.5f).toFile(dest);
       } catch (IOException e) {
         throw new RuntimeException("创建图片失败：" + e.toString());
       }
       relativeAddrList.add(relativeAddr);
     }
    }
    return relativeAddrList;
  }

  /**
   * 创建目标路径涉及的目录，即/home/work/aaa/xxx.jpg
   * 那么需要创建home work aaa 三个目录
   * @param targetAddr
   */
  private static void makeDirPath(String targetAddr) {
    String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
    File dirPath = new File(realFileParentPath);
    if (!dirPath.exists()) {
     dirPath.mkdirs();
    }
  }

  /**
   * 获取输入文件流的扩展名
   * @param cFile
   * @return
   */
  private static String getFileExtension(CommonsMultipartFile cFile) {
    String originalFileName = cFile.getOriginalFilename();
    return originalFileName.substring(originalFileName.lastIndexOf("."));
  }
}
