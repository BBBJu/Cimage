package com.example.cimage.Controller;
import com.example.cimage.Poivo;
import com.example.cimage.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import com.peersafe.base.client.pubsub.Publisher.Callback;
import com.peersafe.chainsql.core.Chainsql;
import com.peersafe.chainsql.core.Ripple;
import com.peersafe.chainsql.core.Submit.SyncCond;
import com.peersafe.chainsql.net.Connection;
import com.peersafe.chainsql.util.Util;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
@RestController
@CrossOrigin
public class SelectImgController {
    public static final Chainsql c = new Chainsql();
    public static String gmRootAddress = "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh";
    public static String gmRootSecret = "xnoPBzXtMeMyMHUVTgbuqAfg1SUTb";

    // @Autowired
    // FieldService fs = new FieldService();

    //@RequestMapping("/saveField")
    @GetMapping("/list")
    public Result saveField() throws IOException {
        //String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

        /* 保存图片到指定目录
        String uploadDirectory = "D:\\ChainSQL\\CimageY\\upload";
        String filePath = Paths.get(uploadDirectory, originalFileName).toString();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        在方法内部将需要的字符串转换为其他数据类型*/

        //System.out.println(fileName1);
        //System.out.println(description1);
        //System.out.println(filePath);

        // 在这里，fieldData 对象已经包含了前端传递的字段数据
        //int name = fieldData.getname();
        //String path = fieldData.getpath();
        //int description = fieldData.getdescription();

        /*  杨加的注释
        JSONObject obj = null;
        try {
            Connection con = c.connect("wws://192.168.3.47:6006");
            if (con == null) {
                System.out.println("can not connect");
                return Result.failed();
            }
            c.as(gmRootAddress, gmRootSecret);

            String sTableName = "test_chainghue4";
            c.use(gmRootAddress);
            //查询所有数据
            obj = c.table(sTableName).get(Util.array("{name:hello}")).submit();
            System.out.println("get result:" + obj);
            return Result.success(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failed();*/
        List<JSONObject> jsonList = new ArrayList<>();
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Object 1");
        obj1.put("owner", "Owner 1");
        obj1.put("status", "Status 1");
        jsonList.add(obj1);
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "Object 2");
        obj2.put("owner", "Owner 2");
        obj2.put("status", "Status 2");
        jsonList.add(obj2);

        Gson gson = new Gson();
        String json = gson.toJson(jsonList);
        System.out.println("get result:"+jsonList);
        return Result.success(json);
    }
}
