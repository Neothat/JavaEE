package ru.geekbrains.ee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductListServlet", urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {

    private final Product[] products = new Product[9];
    private static final Logger logger = LoggerFactory.getLogger(ProductListServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("init method");

        for (int i = 0; i < 10; i++) {
            products[i] = new Product(i++, "Product_" + i, (int) (20 + Math.random() * 100));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet method");

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (Product product : products) {
            resp.getWriter().println("<h1>" + product.toString() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }
}
