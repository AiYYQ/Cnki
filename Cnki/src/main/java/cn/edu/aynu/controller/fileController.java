package cn.edu.aynu.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Controller
public class fileController {

    /**
     * 文件上传
     * @param request
     * @param file
     * @return
     * @throws IOException
     */

    @RequestMapping("uploadFile")
    public String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
//      得到路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("path="+path);

        File file1 = new File(path);
//        判断文件是否存在,不存在则创建
        if (!file1.exists()){
            file1.mkdirs();
        }
        //得到文件原始名称
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + filename;
        file.transferTo(new File(path,filename));

        return "upload";
    }


    /**'
     *          文件下载
     * @param request
     * @param response
     * @param fileName  超链接传过来文件名字
     * @param fileType  超链接处传过来文件类型
     * @throws IOException
     */
    @RequestMapping("downloadFile")
    public void downloadFile(HttpServletRequest request,HttpServletResponse response,String fileName,String fileType) throws IOException {
        //读取服务器文件
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path+"/"+fileName);

        response.setContentLength((int) file.length());
        response.setContentType(fileType);

        InputStream inputStream = new FileInputStream(file);
        //写到本地硬盘
        OutputStream outputStream = response.getOutputStream();

        IOUtils.copy(inputStream,outputStream);
        //关闭输入输出流
        inputStream.close();
        outputStream.close();
    }
}
