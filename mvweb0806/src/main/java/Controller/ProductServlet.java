package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import Model.Product;

@WebServlet(urlPatterns={"/ShowProductDAO"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext(); 
	    ArrayList list = prepareArrayList();
	    request.setAttribute("catalog" , list);
	    RequestDispatcher  forwardPage = request.getRequestDispatcher("show.jsp");
	    try {
	    	forwardPage.forward(request , response);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }

	}
	
	public ArrayList  prepareArrayList(){
        ArrayList list ;
        ProductDao dao= new ProductDao();
        list = dao.getProductList();
        return list;
  }

}
