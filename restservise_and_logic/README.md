# REST Service and Logic
This is a folder for files that support and integrate REST service of the application and provide logic for the application.


*.war* file is in target -> *psf-rest.war*

1. Copy WAR file from target/psf-rest.war to the tomcat/webapps/ folder
2. From a terminal navigate to tomcat/bin folder and execute
    * catalina.bat run (on Windows)
3. Go to http://localhost:8080/psf-rest/*API*


## API

*/auth* - protected end-points

*/public* - public end-points

### */auth/login*    

headers: Authorization Bearer Token

**METHOD:** "POST"

Params: ```void```

Returns:
```json
{
  "id": 4,
  "name": "John",
  "lastName": "Doe",
  "email": "John.Doe@gmail.com",
  "userType": 0,
  "address": null,
  "points": 0,
  "monthlyOrders": 0
}
```

### */public/products*

**METHOD:** "POST"

Params: ```void ```

Returns: 
```json
[
    {
        "idProd": 1,
        "productName": "Napoletana",
        "productPrice": 12.35,
        "discountForPremiumUsers": 20,
        "productSize": 100,
        "productDescription": "mozzarella cheese, baked ham, mushroom, artichoke and tomato and pizza pugliese, prepared with tomato, mozzarella and onions",
        "image": "BASE64 String"  
    },
    {
        "idProd": 2,
        "productName": "Margherita",
        "productPrice": 15.99,
        "discountForPremiumUsers": 69,
        "productSize": 100,
        "productDescription": "San Marzano tomatoes, mozzarella fior di latte, fresh basil, salt and extra-virgin olive oil",
        "image": "BASE64 String"
    },
    {
        "idProd": 3,
        "productName": "Quattro stagioni",
        "productPrice": 20.99,
        "discountForPremiumUsers": 21,
        "productSize": 100,
        "productDescription": "artichokes, tomatoes or basil, mushrooms and ham or prosciutto, or olives",
        "image": "BASE64 String"
    }
]
```
<hr>

### */public/product/PARAMS*

**METHOD:** "GET"

Params: ```String productName ```

Returns:
```json
{
  "idProd": 2,
  "productName": "Margherita",
  "productPrice": 15.99,
  "discountForPremiumUsers": 69,
  "productSize": 100,
  "productDescription": "San Marzano tomatoes, mozzarella fior di latte, fresh basil, salt and extra-virgin olive oil",
  "image": "BASE64 String"
}
```

<hr>

### */public/additions*

**METHOD:** "POST"

Params: ```void```

Returns: 
```json
[
    {
        "id": 1,
        "additionName": "Bacon",
        "additionPrice": 0.5
    },
    {
        "id": 2,
        "additionName": "Cheese",
        "additionPrice": 0.25
    },
    {
        "id": 3,
        "additionName": "Mushroom",
        "additionPrice": 0.75
    }
]
```

<hr>


### */public/contact*

**METHOD:** "GET"

Params: 
```
    String customerMail,
    String name,
    String subject
    String msg
```
Returns: ```void```
<hr>

### */public/address*

**METHOD:** "GET"

Params
```
    String userAddress
```

Returns: ```void```
<hr>

### */auth/order*

**METHOD:** "POST"

headers: Authorization Bearer Token

headers: Content-type application/json

Params ```void```

JSON Body
```json
[
    {
      "mail": "joh.doe@gmail.com",
      "userType": 0 or 1,
      "productName": "Margherita",
      "payment": "paypal",
      "quantity": 1,
      "orderNum": 1234,
      "additionName": "Bacon" or ""
    },
    ...
]

``` 
Returns: ```void```

<hr>

### */public/newsletter*

**METHOD:** "GET"

Params: ```String customerMail``` 

Returns: ```void```