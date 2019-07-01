function getProductNameFromURL() {
    var productName = window.location.search;
    productName = productName.substring(1, productName.length);
    return productName;
}

function decodeBase64(base64String) {
    var image = new Image();
    image.src = 'data:image/png;base64,' + base64String;
    return image.src;
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
            saveToCookie(idToken, response.email, response.userType);
            //console.log(response);
        }
    });
}

function saveToCookie(idToken, email, userType) {
    var date = new Date();
    date.setTime(date.getTime() + (2 * 3600 * 1000));
    document.cookie = "token=" + idToken + "; path=/";
    document.cookie = "userEmail=" + email;
    document.cookie = "userType=" + userType;
    document.cookie = "expires=" + date.toUTCString();
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    console.log(gapi);
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
