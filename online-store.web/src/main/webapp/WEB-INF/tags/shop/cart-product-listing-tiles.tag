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
							<h3>${cartProduct.product.productName}</h3>
						</div>
					</div>
					<div class="col-md-6">
						<div class="right-big-b">
							<div class="tight-btn-b clearfix">
								<h2>$${cartProduct.product.price}</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<div class="col-md-5 col-sm-16">
            <div class="price-box-right">
               	<a href="#">Buy All</a>
            </div>
        </div>
		
	</div>
</div>