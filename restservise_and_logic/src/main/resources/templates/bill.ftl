<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>
<img src="psflogo.png">
<table>
    <tr>
        <th>Product</th>
        <th>Qt.</th>
        <th>Product Price (€)</th>
        <#if userType == true>
            <th>Discount (%)</th>
            <th>Addition</th>
            <th>Addition price</th>
        </#if>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.productName}</td>
            <td>${product.quantity}</td>
            <td>${product.productPrice}</td>
            <#if userType == true>
                <td>${product.discount}</td>
                <td>${product.addName}</td>
                <td>${product.addPrice}</td>
            </#if>
        </tr>
    </#list>
</table>
<div>Bill info:</div>
<div>${userName} ${userLastname}</div>
<div>${userAddress}</div>
<div>${orderTime}</div>
<div>Total order price: ${totalPrice}</div>
</body>
</html>