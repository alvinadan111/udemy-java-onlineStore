<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags/shop"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Cart Products Page</title>
      <shop:css-imports-main/>
   </head>
   <body>
      <shop:header/>
      <div class="furniture-box">
         <div class="container">
            <div class="row">
				<div class="furniture-main">
					<shop:cart-product-listing-tiles/>
				</div>
			</div>
         </div>
      </div>
     <shop:footer/>
     <shop:js-imports-main/>
     
   </body>
</html>