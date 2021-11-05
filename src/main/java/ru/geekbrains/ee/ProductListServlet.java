package ru.geekbrains.ee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductListServlet", urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            resp.getWriter().printf("<h2>" + new Product(i+1, "Product_" + i, (int) (20 + Math.random() * 100)) + "</h2>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }
}
