<%@ include file="./header.jspf"%>
<!-- main content area -->

<h3>${ pageTitle==null? "Customer form": pageTitle }</h3>

<hr>

<form method="POST">

	<div class="form-group row">
		<label class="col-md-3 text-right" for="name">Name :</label>
		<div class="col-md-6">
			<input type="text" name="name" id="name" class="form-control" value="${param.name}" >
			<div class="text-danger">${errors.name}</div>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3 text-right" for="city">City :</label>
		<div class="col-md-6">
			<input type="text" name="city" id="city" class="form-control" value="${param.city}" >
			<div class="text-danger">${errors.city}</div>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3 text-right" for="email">Email address :</label>
		<div class="col-md-6">
			<input type="email" name="email" id="email" class="form-control" value="${param.email}" >
			<div class="text-danger">${errors.email}</div>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3 text-right" for="phone">Phone number :</label>
		<div class="col-md-6">
			<input type="tel" name="phone" id="phone" class="form-control" value="${param.phone}" >
			<div class="text-danger">${errors.phone}</div>
		</div>
	</div>

	<div class="form-group row">
		<label class="col-md-3"></label>
		<div class="col-md-6">
			<button class="btn btn-primary">Submit</button>
		</div>
	</div>

</form>

<%@ include file="./footer.jspf"%>