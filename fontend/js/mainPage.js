
$.ajax({
    type: "POST",
    url: "http://localhost:8080/public/products",
    dataType: "json",
    success: function (result) {
        result.forEach(element => {
            displayProduct(element);
        });
    }
});

function displayProduct(product) { 
    $("body > .container > .row > .col-lg-9 > .row").append(
       "<div class=\"col-lg-4 col-md-6 mb-4\">"+
            "<div class=\"card h-100\">"+
              "<a href=\"#\"><img class=\"card-img-top\" src=\""+decodeBase64(product.image)+"\"></a>"+
              "<div class=\"card-body\">"+
                "<h4 class=\"card-title\">"+
                  "<a href=\"item.html?"+product.productName+"\">"+product.productName+"</a>"+
                "</h4>"+
                "<h5>€"+product.productPrice+"</h5>"+
                "<p class=\"card-text\">"+product.productDescription+"</p>"+
              "</div>"+
           "</div>"+
         "</div>"
    );
    
    console.log(product.productName);
}

function decodeBase64(base64String) {
    var image = new Image();
    image.src = 'data:image/png;base64,' + base64String;
    return image.src;
}

function onSignIn(googleUser) {
    var id_token = googleUser.getAuthResponse().id_token;
    //console.log(id_token);
    logInToREST(id_token);
}

function logInToREST(idToken) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/auth/login",
        headers: { "Authorization": "Bearer " + idToken },
        dataType: "json",
        success: function (response) {
            
            saveToCookie(idToken, response);
            console.log(response);
        }
    });
}

function saveToCookie(idToken, response) {
  
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    console.log(gapi);
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }