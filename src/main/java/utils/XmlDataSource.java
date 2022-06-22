package utils;

import entity.Painting;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-22 14:57
 **/

// 管理着DAO对象，从XML中读取

// 数据源类：

public class XmlDataSource {
    // 使用static 静态关键字保证数据全局唯一
    private static List data = new ArrayList<>();
    private static String dataFile;
    static {
        // User/Files/data source/file.txt
        // Base64编码
        // User/Files/data%20source/file.txt
        dataFile = XmlDataSource.class.getResource("/painting.xml").getPath();
        URLDecoder decoder = new URLDecoder();
        try {
            dataFile = decoder.decode(dataFile,"UTF-8");
            System.out.println(dataFile);

            // 使用Dom4j对XML进行解析
            SAXReader reader = new SAXReader();
            // 1. 获取Document对象
            Document document = reader.read(dataFile);
            // 2. Xpath 得到XML节点集合
            List<Node> nodes = document.selectNodes("root/painting");
            for(Node node : nodes){
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String pname = element.elementText("pname");

                Painting painting = new Painting();
                painting.setId(Integer.parseInt(id));
                painting.setPname(pname);
                painting.setCategory(Integer.parseInt(element.elementText("category")));
                painting.setPrice(Integer.parseInt(element.elementText("price")));
                painting.setPreview(element.elementText("preview"));
                painting.setDescription(element.elementText("description"));

                data.add(painting);
                System.out.println(id + " : " + pname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Painting> getRawData(){
        return data;
    }

    public static void main(String[] args) {
        new XmlDataSource();
        List<Painting> list = XmlDataSource.getRawData();
        System.out.println(list);
    }
}
