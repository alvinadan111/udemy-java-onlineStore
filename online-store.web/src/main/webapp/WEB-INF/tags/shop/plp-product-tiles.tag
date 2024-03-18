<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags/shop"%>

<div class="col-md-6 col-sm-8">
	<div class="furniture-middle">
	
	
		<c:forEach items="${products}" var="product">
			<div class="big-box">
				<div class="big-img-box">
					<a href="product?guid=${product.guid}"><img src="images/product/${product.imgName}" alt="#" /></a>
				</div>
				<div class="big-dit-b clearfix">
					<div class="col-md-6">
						<div class="left-big">
							<h3>${product.productName}</h3>
						</div>
					</div>
					<div class="col-md-6">
						<div class="right-big-b">
							<div class="tight-btn-b clearfix">
								<c:if test="${not empty loggedInUser}">
									<a class="view-btn" href="addToCart?guid=${product.guid}&categoryId=${categoryId}&page=${activePage}">Add To Cart</a> 
								</c:if>
								<c:if test="${empty loggedInUser}">
									<a class="view-btn" href="signin">Add To Cart</a> 
	                     		</c:if>
									<a href="product?guid=${product.guid}">$${product.price}</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<shop:pagination/>
		
	</div>
</div>