// Handle vendor login
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData();
    formData.append('email', document.getElementById('email').value);
    formData.append('password', document.getElementById('password').value);

    fetch("http://localhost:8080/backend/VendorLoginServlet", {
        method: "POST",
        body: formData
    })
    .then(response => response.text())
    .then(data => {
        console.log("Login response:", data);
        alert("Login successful!");
        fetchProducts(); // Load products after login
    })
    .catch(error => {
        console.error("Login error:", error);
        alert("Login failed.");
    });
});

// Fetch product list
function fetchProducts() {
    fetch("http://localhost:8080/backend/FetchProductsServlet")
        .then(response => response.json())
        .then(products => {
            const container = document.getElementById('products');
            container.innerHTML = ''; // Clear previous
            products.forEach(product => {
                const div = document.createElement('div');
                div.className = 'product-item';
                div.innerHTML = `
                    <h3>${product.name}</h3>
                    <p>Price: ₹${product.price}</p>
                    <p>${product.description}</p>
                `;
                container.appendChild(div);
            });
        })
        .catch(error => {
            console.error("Error fetching products:", error);
        });
}

