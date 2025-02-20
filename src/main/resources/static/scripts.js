const API_BASE_URL = "http://localhost:8080/api";

const loginButton = document.getElementById("login-button");
const registerButton = document.getElementById("register-button");
const loginForm = document.getElementById("login-form");
const registerForm = document.getElementById("register-form");
const switchToRegisterButton = document.getElementById("switch-to-register");
const switchToLoginButton = document.getElementById("switch-to-login");
const dashboard = document.getElementById("dashboard");

let user_id = 0;

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

        if (response.ok) {
            loginForm.style.display = "none";
            dashboard.style.display = "flex";

            user_id = await response.text();
            await getStudents(user_id);
        }
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

const getStudents = async (id) => {
    try {
        const response = await fetch(`${API_BASE_URL}/students/${id}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });

        if (response.ok) {
            const studentTable = document.getElementById("student-table");
            const students = await response.json();
            studentTable.innerHTML = students.map(student => `
                <tr>
                  <td>${student.id}</td>
                  <td>${student.fullName}</td>
                  <td>${student.age}</td>
                  <td>${student.phoneNumber}</td>
                  <td>${student.address}</td>
                  <td><button onclick="deleteStudent(${student.id})">Delete</button></td>
                </tr>
            `).join("");
        }
    } catch (error) {
        console.error("Error fetching students:", error);
    }
};

const deleteStudent = async (id) => {
    const promptResponse = confirm("Are you sure you want to delete this student?");
    if (promptResponse) {
        try {
            const response = await fetch(`${API_BASE_URL}/students/${id}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            });

            if (response.ok) {
                await getStudents(user_id);
                alert("Student deleted successfully.");
            } else {
                alert("Failed deleting student.");
            }
        } catch (error) {
            console.error("Error deleting student:", error);
        }
    }
};