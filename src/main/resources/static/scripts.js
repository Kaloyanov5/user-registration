const API_BASE_URL = "http://localhost:8080/api";

const loginButton = document.getElementById("login-button");
const registerButton = document.getElementById("register-button");
const loginForm = document.getElementById("login-form");
const registerForm = document.getElementById("register-form");
const switchToRegisterButton = document.getElementById("switch-to-register");
const switchToLoginButton = document.getElementById("switch-to-login");

loginButton.addEventListener("click", async () => {
    const username = document.getElementById("login-username").value;
    const password = document.getElementById("login-password").value;

    try {
        const response = await fetch(`${API_BASE_URL}/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        alert(response.ok ? "Login successful" : "Login failed. Please check your credentials.");
    } catch (error) {
        console.error("Error logging in:", error);
    }
});

registerButton.addEventListener("click", async () => {
    const username = document.getElementById("register-username").value;
    const password = document.getElementById("register-password").value;
    const confirmPassword = document.getElementById("register-confirm-password").value;

    try {
        const response = await fetch(`${API_BASE_URL}/register`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password, confirmPassword })
        });

        if (response.ok) {
            alert("User registered successfully!");
            registerForm.style.display = "none";
            loginForm.style.display = "flex";
        } else {
            alert("Registration failed. Please try again.");
        }
    } catch (error) {
        console.error("Error registering:", error);
    }
})

switchToRegisterButton.addEventListener("click", () => {
    loginForm.style.display = "none";
    registerForm.style.display = "flex";
});

switchToLoginButton.addEventListener("click", () => {
    registerForm.style.display = "none";
    loginForm.style.display = "flex";
});