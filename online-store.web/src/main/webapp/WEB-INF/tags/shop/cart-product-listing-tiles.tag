<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags/shop"%>

<div class="col-md-6 col-sm-8">
	<div class="furniture-middle">
	
		<c:forEach items="${cartProducts}" var="cartProduct">
			<div class="big-box">
				<div class="big-img-box">
					<img src="images/product/${cartProduct.product.imgName}" alt="#" />
				</div>
				<div class="big-dit-b clearfix">
					<div class="col-md-6">
						<div class="left-big">
							<h2>${cartProduct.product.productName}</h2>
						</div>
					</div>
					<div class="col-md-6">
						<div class="right-big-b">
							<div class="tight-btn-b clearfix">
								<h3>$${cartProduct.product.price}</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
		
         <c:if test="${empty cartProducts}">
             	<h2>No products added to cart yet.</h2>
         </c:if>
         
		 <div class="col-md-5 col-sm-16">
            
            <c:if test="${not empty cartProducts}">
	            <div class="price-box-right">
	               <a href="checkout-all">Buy All</a>
	            </div>
            </c:if>
        </div>
		
	</div>
</div>