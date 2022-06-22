package controller;

import entity.Painting;
import service.PaintingService;
import utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chris Yang
 * created 2022-06-22 16:09
 **/


@WebServlet("/page")
public class PaintingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PaintingService paintingService = new PaintingService();

    public PaintingController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收Http数据
        String page = req.getParameter("p");
        String rows = req.getParameter("r");
        String category = req.getParameter("c");

        if(page == null){
            page = "1";
        }
        if(rows == null){
            rows = "6";
        }

        // 2. 调用Service方法处理结果
        PageModel pageModel =  paintingService.pagination(Integer.parseInt(page),Integer.parseInt(rows),category);
        req.setAttribute("pageModel",pageModel);

        // 3. 请求转发到对应的JSP（view）进行数据展现
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
    }
}
