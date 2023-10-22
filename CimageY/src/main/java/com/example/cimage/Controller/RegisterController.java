/*package com.example.cimage.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.json.JSONObject;
import com.peersafe.base.client.pubsub.Publisher.Callback;
import com.peersafe.chainsql.core.Chainsql;
import com.peersafe.chainsql.core.Ripple;
import com.peersafe.chainsql.core.Submit.SyncCond;
import com.peersafe.chainsql.net.Connection;
import com.peersafe.chainsql.util.Util;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RegisterController {
    public static final Chainsql c = new Chainsql();
    public static String gmRootAddress = "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh";
    public static String gmRootSecret = "xnoPBzXtMeMyMHUVTgbuqAfg1SUTb";

    // @Autowired
    // FieldService fs = new FieldService();


    //@RequestMapping("/saveField")
    @PostMapping("/upload")
    public void saveField(@RequestParam("file") MultipartFile file,
                          @RequestParam("fileName") String fileName,
                          @RequestParam("description") String description) throws IOException {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

        // 保存图片到指定目录
        String uploadDirectory = "D:\\ChainSQL\\CimageY\\upload";
        String filePath = Paths.get(uploadDirectory, originalFileName).toString();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        // 在方法内部将需要的字符串转换为其他数据类型

        //System.out.println(fileName1);
        //System.out.println(description1);
        System.out.println(filePath);

        // 在这里，fieldData 对象已经包含了前端传递的字段数据
        //int name = fieldData.getname();
        //String path = fieldData.getpath();
        //int description = fieldData.getdescription();

        try {
            Connection con = c.connect("wws://192.168.3.47:6006");
            if (con == null) {
                System.out.println("can not connect");
                return;
            }
            c.as(gmRootAddress, gmRootSecret);

            String sTableName = "gmTesthuyu";
            // int a1 = 423283;
            //int fileName1 = Integer.parseInt(fileName);
            //int description1 = Integer.parseInt(description);
            String sNewAccountId1 = "sNewAccountId";

            JSONObject options = new JSONObject();
            options.put("algorithm","softGMAlg");
            JSONObject obj = c.generateAddress(options);
            System.out.println("new account:" + obj);
            String account = obj.getString("address");
            String sNewSecret = obj.getString("secret");
            //激活账户
            Ripple ripple = new Ripple(c);
            JSONObject ret = ripple.pay(account, "200").submit(SyncCond.validate_success);
            System.out.println("pay result:" + ret);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

*/
