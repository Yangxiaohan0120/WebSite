package dao;

import entity.Painting;
import utils.PageModel;
import utils.XmlDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-22 15:54
 **/
public class PaintingDao {

    /*
     * @description 分页查询油画数据
     * @author yxh
     * @date  2022-06-22 15:56:22
     * @param: page 页号
     * @param: rows 每页记录数
     * @return PageModel 分页对象
     */
    public PageModel pagination(int page,int rows){
        // painting油画对象合集
        List<Painting> list = XmlDataSource.getRawData();
        // PageModel分页处理得到的分页数据及分页附加项
        PageModel pageModel = new PageModel(list,page,rows);
        return pageModel;
    }

    public PageModel pagination(int category,int page,int rows){
        List<Painting> list = XmlDataSource.getRawData();
        List<Painting> categoryList = new ArrayList<>();
        for (Painting p : list) {
            if(p.getCategory() == category){
                categoryList.add(p);
            }
        }

        PageModel pageModel = new PageModel(categoryList,page,rows);
        return pageModel;
    }
}
