package com.neu.edu.service.impl;

import com.neu.edu.mapper.GoodsMapper;
import com.neu.edu.vo.GoodsVO;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class QiniuService {
    private static final Logger logger = LoggerFactory.getLogger(QiniuService.class);
    // 账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "E5faApJVF9U2u9GGs3RbdYV5G_qnH7zQFw7uejWp";
    String SECRET_KEY = "9ZLgrdFBSEvBEBPIVOuurkxyZN_8QdfkKNc0qKUr";
    // 要上传的空间
    String bucketname = "wj-market-db";
    //空间域名
    private String domain = "http://rxrn6jff8.hn-bkt.clouddn.com";
    //文件名路径前缀
    private String prefix = "goods";
    //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串

    private String delimiter = "";
    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 构造一个带指定Zone对象的配置类:华南地区为z2
    Configuration cfg = new Configuration(Zone.zone2());
    long expireInSeconds = 3600;//1小时，链接过期时间

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    /**
     * 获取七牛云中存储的所有商品图片的外链
     * @return
     */
    public Map<String,String> getUrls() throws UnsupportedEncodingException {
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //每次迭代的长度限制，最大1000
        int limit = 1000;
        Map<String, String> fileNameMap = new HashMap<>();
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucketname, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            //stream流过滤掉掉多余的元素，并将其余元素的所有文件路径和域名进行拼接，返回所有图片外链的集合
            Arrays.stream(items)
                    .filter(f -> !f.key.equals(prefix))
                    .forEach(f -> {
                        String fileName = f.key;
                        String encodedFileName = null;
                        try {
                            encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        String publicUrl = String.format("%s/%s", domain, encodedFileName);
                        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
                        fileNameMap.put(f.key, finalUrl);
//                        System.out.println(f.key+":"+finalUrl);
                    });
        }
        return fileNameMap;
    }

}

