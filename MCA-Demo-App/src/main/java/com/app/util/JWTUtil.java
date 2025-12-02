package com.app.util;

import java.net.SecureCacheResponse;
import java.util.Date;

import com.app.database.DatabaseConnection;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

//there will be two functions in this class, one will be used to create the JWT token.
//The other function will be used to verify the JWT token.
public class JWTUtil {
	static final String secret = "thiscodeistopsecret";
	//here we are doing the encryption using SHA 256 (Secure Hash Algorithm --> 256 bytes)
	static Algorithm algo = Algorithm.HMAC256(secret);
	
	static Date currentDateTime = new Date(); // this has today's date and current time
	static long expireDuration = 30 * 60 * 1000;
	static long currentTime = currentDateTime.getTime();
	static Date expireDateTime = new Date(currentTime + expireDuration);
	
	public static String createJWT(String email, int phone, String name, int otp) {
		String token = JWT.create()
		.withSubject(email)
		.withExpiresAt(expireDateTime)
		.withClaim("otp", otp)
		.withClaim("userPhone", phone)
		.withClaim("userName", name)
		.withClaim("gender", "F")
		.withIssuedAt(currentDateTime)
		.withIssuer("MCA")
		.sign(algo);
		return token;
	}
	
	public static String verifyJWT(String token) {
		try {
			DatabaseConnection.updateTokenUseCount(token);
			 DecodedJWT decodedToken = JWT.require(algo)
						.build().verify(token);
			 return decodedToken.getSubject().toString();
//			 System.out.println("TOKEN IS VALID");
//			 System.out.println("The issuer is " + decodedToken.getIssuer());
//			 System.out.println("The email add is " + decodedToken.getSubject());
//			 System.out.println("The OTP is " + decodedToken.getClaim("otp"));
//			 System.out.println("The Phone is " + decodedToken.getClaim("userPhone"));
//			 System.out.println("The name is " + decodedToken.getClaim("userName"));
//			 System.out.println("The Gender is " + decodedToken.getClaim("gender"));
//			 System.out.println("This token was created at " + decodedToken.getIssuedAt());
//			 System.out.println("This token will expire at " + decodedToken.getExpiresAt());
		} catch (Exception e) {
			System.out.println("TOKEN IS EXPIRED");
			return null;
		}
		
	}
	
	
	public static void main(String a[]) {
//		createJWT("piebytwo014@gmail.com", 1234234, "Vivek", 245432); // create token
		
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJwaWVieXR3bzAxNEBnbWFpbC5jb20iLCJleHAiOjE3NjM5NTkxNDEsIm90cCI6MjQ1NDMyLCJ1c2VyUGhvbmUiOjEyMzQyMzQsInVzZXJOYW1lIjoiVml2ZWsiLCJnZW5kZXIiOiJGIiwiaWF0IjoxNzYzOTU4OTYxLCJpc3MiOiJNQ0EifQ.lmo0N5Oxuwwl-HBMleD9MFHRSdhqMseC4VzeRC9fk38";
		verifyJWT(token);
		
	}
}
