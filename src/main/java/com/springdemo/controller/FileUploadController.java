package com.springdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
@RequestMapping("/admin")
public class FileUploadController {
	@ResponseBody
	@RequestMapping(value = "/photoUpload",method = RequestMethod.POST)
	public  String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model){
		 String path=null;// 文件路径
		 if (file!=null) {// 判断上传的文件是否为空
                
                String type=null;// 文件类型
                String fileName=file.getOriginalFilename();// 文件原名称
                // 判断文件类型
                type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
                if (type!=null) {
                	System.out.println(file.getSize());
                	try {
						System.out.println(file.getBytes().length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
					if(file.getSize()> 1024*1024*10){
                		return "上传图片过大";
                	}
                	// 判断文件类型是否为空
                    if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                        // 项目在容器中实际发布运行的根路径
                        String realPath=request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
                        String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                        // 设置存放图片文件的路径
                        path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
                        System.out.println("存放图片文件的路径:"+path);
                        // 转存文件到指定的路径
                        try {
							file.transferTo(new File(path));
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        System.out.println("文件成功上传到指定目录下");
                    }else {
                        System.out.println("不是我们想要的文件类型,请按要求重新上传");
                        return "不是我们想要的文件类型,请按要求重新上传";
                    }
                }else {
                    System.out.println("文件类型为空");
                    return "文件类型为空";
                }
            }else {
                System.out.println("没有找到相对应的文件");
                return "没有找到相对应的文件";
            }
		 Gson gson = new Gson();
		 String json = gson.toJson(path);
		 return json;
        }
	
}
