package cn.xyh.d_fileUpload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

public class FileUpload extends ActionSupport {
    // 对应表单中文件域的名字
    private File file1;

    // 文件名
    private String file1FileName;

    // 文件类型
    private String file1ContentType;

    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public void setFile1FileName(String file1FileName) {
        this.file1FileName = file1FileName;
    }

    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    @Override
    public String execute() throws Exception {
        /*********拿到上传的文件，进行处理*********/

        // 上传到指定目录

        // 获取上传文件的目标目录
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        File destFile = new File(path, file1FileName);
        FileUtils.copyFile(file1, destFile);
        return SUCCESS;
    }
}
