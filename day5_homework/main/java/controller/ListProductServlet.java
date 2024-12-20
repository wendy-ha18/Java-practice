package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PagingDAO;
import entity.Product;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	try {
    		String indexPage = request.getParameter("page");
    		if (indexPage == null) {
    			indexPage = "1";
    		}
    		
    		System.out.println(indexPage);
    		
    		//chuyen data type của page từ String sang int
    		int page = Integer.parseInt(indexPage);
    		//truyen page vao DAO
    		
    		
	    	//count total account in DB
			PagingDAO pagingDao = new PagingDAO();
			int count = pagingDao.getTotalProduct();
			
			int maxPage = count/4; // moi trang 2 bai
			if(count%4 !=0) { // neu chia du, so trang +1
				maxPage++;
			}
			
			System.out.println(maxPage);
			
			List<Product> list = pagingDao.pagingProduct(page);
			
			//truyen list vao page A trang listProduct.jsp
			request.setAttribute("pageA", list);
		
			request.setAttribute("maxP", maxPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("listProduct.jsp");
			rd.forward(request, response);
			
			System.out.println("maxP");
			
    	}
    	
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		
	}

	

}
