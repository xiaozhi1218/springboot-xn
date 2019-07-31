package com.mtl.common.oss;

import com.mtl.common.tool.api.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 图片上传
 *
 * @author Sami
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/image")
@Api(value = "图片上传", tags = "图片上传")
public class imgUploadController {

	@RequestMapping(value = "/imageUpload",method = RequestMethod.POST)
	@ApiOperation(value = "WebUploader图片上传")
	public String uploadFile(@RequestParam("file") MultipartFile files,
							 HttpServletRequest request){

		String imagePath=null;
		String fileName=files.getOriginalFilename();
		try {
			//上传七牛云服务器
			imagePath= QiniuUtil.qiniuUpload(files.getBytes(),fileName);
			if(imagePath.contains("error")){
				System.out.println("上传失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imagePath;
	}

	@RequestMapping(value = "/delImage",method = RequestMethod.GET)
	@ApiOperation(value = "删除图片")
	public Object delFile(@RequestParam("url") String url){
		String str=QiniuUtil.delFile(url);
		return  str;
	}

}
