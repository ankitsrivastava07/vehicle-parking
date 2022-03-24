<!doctype html>
<html lang="en">
  <head>
  	<title>Sign In </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/login-form/css/style.css">

	</head>
<style>
span#err_password {
font-size: 14px;
color: #ef8484;
}

span#err_email {
font-size: 14px;
color: #ef8484;
}

.btn.btn-primary:hover {
border: rgba(240, 25, 60, 1)!important;
background: rgba(240, 25, 60, 1)!important;
color: fff;
}

.login-wrap .icon {
width: 80px;
height: 80px;
background: rgba(240, 25, 60, 1)!important;
border-radius: 50%;
font-size: 30px;
margin: 0 auto;
margin-bottom: 10px;
color: rgba(240, 25, 60, 1)!important;
}

.btn.btn-primary {
background: rgba(240, 25, 60, 1)!important;
border: rgba(240, 25, 60, 1)!important;
color: #fff !important;
}

.alert {
text-align: center;
background-color: #545353;
border-color: #545353;
color: white;
font-weight: bold;
margin-right: auto;
word-spacing: 7px;
margin-left: auto;
width: fit-content;
font-size: small;
box-shadow: 0 25px 15px 0 rgb(0 0 0 / 40%);
}

.alert {
position: relative;
padding: 0.75rem 1.25rem;
/* margin-bottom: 1rem; */
/* border: 1px solid transparent; */
border-radius: 0.25rem;
}
</style>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Sign In</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
		      	<div class="icon d-flex align-items-center justify-content-center">
		      		<span class="fa fa-user-o"></span>
		      	</div>
		      	<h3 class="text-center mb-4">Have an account?</h3>
						<form action="#" class="login-form">
		      		<div class="form-group">
                     <span>Email or mobile</span>
		      			<input type="text" class="form-control rounded-left" id="email" placeholder="Email or Mobile enter here">
		      		</div>
	            <div class="form-group">
                <span>Password</span>
	              <input type="password" class="form-control rounded-left" id="password" placeholder="password enter here" >
	            </div>
	            <div class="form-group d-md-flex">
	            	<div class="w-50">
	            		<label class="checkbox-wrap checkbox-primary">Remember Me
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="#">Forgot Password</a>
								</div>
	            </div>
	            <div class="form-group">
	            	<input type="submit" class="btn btn-primary rounded submit p-3 px-5" value="Submit" id="submit">
	            </div>
	          </form>
	        </div>
				</div>
			</div>
		</div>
	</section>
	<script src="/assets/login-form/js/jquery.min.js"></script>
  <script src="/assets/login-form/js/popper.js"></script>
  <script src="/assets/login-form/js/bootstrap.min.js"></script>
<script src="/assets/login-form/js/easyparkingLogin.js"></script>
</body>
</html>

