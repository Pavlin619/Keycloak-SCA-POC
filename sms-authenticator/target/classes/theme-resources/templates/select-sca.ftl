<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Select SCA Method</title>
	<style>
		body { font-family: Arial, sans-serif; }
		.container { max-width: 400px; margin: 0 auto; padding: 2em; }
		h1 { text-align: center; }
		.btn { display: block; width: 100%; padding: 1em; margin-top: 1em; font-size: 1em; cursor: pointer; }
	</style>
</head>
<body>
<div class="container">
	<h1>Select Authentication Method</h1>

	<form action="${url.loginAction}" method="post">
		<div>
			<input type="radio" id="custom_otp" name="sca_choice" value="custom_otp" required>
			<label for="custom_otp">Custom OTP</label>
		</div>
		<div>
			<input type="radio" id="keycloak_authenticator" name="sca_choice" value="keycloak_authenticator" required>
			<label for="keycloak_authenticator">Keycloak Authenticator</label>
		</div>
		<div>
			<input type="radio" id="passkeys" name="sca_choice" value="passkeys" required>
			<label for="passkeys">Passkeys</label>
		</div>

		<button type="submit" class="btn">Continue</button>
	</form>
</div>
</body>
</html>
