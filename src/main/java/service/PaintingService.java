package service;

import dao.PaintingDao;
import entity.Painting;
import utils.PageModel;

import java.util.List;

/**
 * @author Chris Yang
 * created 2022-06-22 15:57
 **/
public class PaintingService {

    private PaintingDao paintingDao = new PaintingDao();


    // String... 可选参数
    public PageModel pagination(int page, int rows, String... category) {
        if (rows == 0) {
            throw new RuntimeException("无效的rows参数");
        }
        if (category.length == 0 || category[0] == null) {
            return paintingDao.pagination(page, rows);
        } else {
            return paintingDao.pagination(Integer.parseInt(category[0]), page, rows);
        }
    }


    public static void main(String[] args) {
        PaintingService paintingService = new PaintingService();
        PageModel pageModel = paintingService.pagination(2, 6);
        List<Painting> paintings = pageModel.getPageData();
        for (Painting painting : paintings) {
            System.out.println(painting.getPname());
        }
        System.out.println(pageModel.getPageStartRow() + " : " + pageModel.getPageEndRow());
    }
}
