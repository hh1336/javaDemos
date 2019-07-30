package mybatis.io;
import java.io.InputStream;

/**
 * 读取文件配置
 */
public class Resources {

    /**
     * 根据传入参数，获取一个字节输入流
     * @param filepath
     * @return
     */
    public static InputStream getResourceAsStream(String filepath){
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
