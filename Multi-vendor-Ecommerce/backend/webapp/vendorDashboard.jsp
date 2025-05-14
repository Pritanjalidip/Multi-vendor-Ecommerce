<!DOCTYPE html>
<html>
<head><title>Vendor Dashboard</title></head>
<body>
    <h2>Welcome Vendor!</h2>
    <form action="addProduct" method="post">
        <input type="text" name="productName" placeholder="Product Name" required><br>
        <textarea name="productDescription" placeholder="Description"></textarea><br>
        <input type="number" name="productPrice" placeholder="Price" required><br>
        <button type="submit">Add Product</button>
    </form>
</body>
</html>