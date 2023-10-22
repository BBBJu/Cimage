package com.example.cimage.Controller;
 import com.example.cimage.Service.AddimageService;
 import org.springframework.beans.factory.annotation.Autowired;
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

 import org.apache.poi.ss.usermodel.*;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
@RestController
@CrossOrigin
public class AddimageController {
    public static final Chainsql c = new Chainsql();
    public static String gmRootAddress = "zHb9CJAWyB4zj91VRWn96DkukG4bwdtyTh";
    public static String gmRootSecret = "xnoPBzXtMeMyMHUVTgbuqAfg1SUTb";

     @Autowired
     private AddimageService addimageService;

    //@RequestMapping("/saveField")
    @PostMapping("/upload")
    public void saveField(@RequestParam("picFile") MultipartFile picFile,
                          @RequestParam("excelFile") MultipartFile excelFile,
                          @RequestParam("fileName") String fileName,
                          @RequestParam("description") String description) throws IOException {
        String originalFileName = StringUtils.cleanPath(picFile.getOriginalFilename());
        String originalFileName_excel = StringUtils.cleanPath(excelFile.getOriginalFilename());

        // 保存图片到指定目录
        String uploadDirectory = "D:\\project\\CimageY\\upload";
        String filePath = Paths.get(uploadDirectory, originalFileName).toString();
        Files.copy(picFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(filePath);

        // 保存excel到指定目录
        String uploadDirectory_excel = "D:\\project\\CimageY\\upload";
        String filePath_excel = Paths.get(uploadDirectory_excel, originalFileName_excel).toString();
        System.out.println(filePath_excel);

        try {
            // 指定要读取的 Excel 文件的路径
            //String filePath = "path/to/your/excel/file.xlsx";

            // 创建文件输入流
           //ileInputStream fis = new FileInputStream(new File(filePath_excel));

            // 使用 XSSFWorkbook 读取 .xlsx 文件
            Workbook workbook = new XSSFWorkbook(excelFile.getInputStream());

            // 获取 Excel 中的第一个工作表
            Sheet sheet = workbook.getSheetAt(0); 

            // 获取行数和列数
            int numRows = sheet.getPhysicalNumberOfRows();
            int numCols = sheet.getRow(0).getPhysicalNumberOfCells();

            // 创建二维数组来存储数据
            String[][] dataArray = new String[numRows][numCols];

            // 遍历工作表的每一行
            for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // 遍历当前行的每个单元格
                for (int colIndex = 0; colIndex < numCols; colIndex++) {
                    Cell cell = row.getCell(colIndex);
                    // 获取单元格的值并存储到二维数组中
                    dataArray[rowIndex][colIndex] = addimageService.getCellValue(cell);
                }
            }

            // 关闭文件输入流
           //is.close();

            // 现在，dataArray 包含了 Excel 表格中的数据，可以根据需要进行进一步处理
            // 你可以通过遍历 dataArray 来访问数据
            try {
                Connection con = c.connect("wws://192.168.3.47:6006");
                if (con == null) {
                    System.out.println("can not connect");
                    return;
                }
                c.as(gmRootAddress, gmRootSecret);

                String sTableName = "test_chainghue4";
                // int a1 = 423283;
                String name = dataArray[1][0];
                String age = dataArray[1][1];
                String filePath1 = "filePath";
                for (int i = 0; i < 1; i++) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", name);
                    jsonObject.put("age", age);
                    jsonObject.put("path", filePath1);

                    // 将 JSON 对象转换为字符串并添加到列表
                    String jsonString = jsonObject.toString();
                    List<String> orgs = Util.array(jsonString);
                    //List<String> orgs = Util.array("{'id':" + fileName1 + ",'CIFSEQjk':" + filePath1 + ",'agfefgh':" + description1 + "}");
                    JSONObject obj;
                    obj = c.table(sTableName).insert(orgs).submit(SyncCond.db_success);
                    System.out.println("insert result:" + obj);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // 示例：打印二维数组中的数据
            for (String[] row : dataArray) {
                for (String cellValue : row) {
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

