package com.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.app.database.DatabaseConnection;
import com.app.util.JWTUtil;

/**
 * Servlet implementation class VerifyOTPServlet
 */
@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		
		if(DatabaseConnection.checkTokenUseCount(token)) {
			String email = JWTUtil.verifyJWT(token);
			boolean verifyStatus = DatabaseConnection.verifyUser(email);
			if(verifyStatus) {
				System.out.println("VERIFICATION SUCCESS");
			}
			else {
				System.out.println("VERIFICATION FAILED");
			}
			
			//this line is used when we were sending otp on user mail, but we don't need this in case of link verification
			
//			String userOTP = request.getParameter("userOTP");
			
//			HttpSession session = request.getSession(false);
//			System.out.println(session.getCreationTime());
//			int sentOTP = (int)(session.getAttribute("sentOTP"));
//			if(Integer.parseInt(tokenOTP) == sentOTP) {
//				System.out.println("sdfsdfds");
////				
//			}else {
//				System.out.println("OTP VERIFICATION FAILED");
//			}
		}
		else {
			System.out.println("The token has been used once");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
