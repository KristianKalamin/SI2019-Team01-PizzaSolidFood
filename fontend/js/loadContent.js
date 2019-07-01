$.ajax({
    type: "GET",
    url: "http://localhost:8080/public/product/" + getProductNameFromURL() + "",
    dataType: "json",
    success: function (product) {
        $("body > .container > .row > .col-lg-9 > .card.mt-4").append(

            "<img class=\"card-img-top img-fluid\" src=\"" + decodeBase64(product.image) + "\">" +
            "<div class=\"card-body\">" +
            " <h3 class=\"card-title\">" + product.productName + "</h3>" +
            "<h4> Pizza size: " + product.productSize + "cm</h4>" + infoForPremium(product) +
            "<h4 id=\"price\"> Pizza price: €" + product.productPrice + "</h4>" +
            "<h4> Quantity: <input type=\"number\" id=\"quantity\" name=\"quantity\" value=1 min=1></h4>" +
            "<h5>Description:</h5>" +
            "<p class=\"card-text\">" + product.productDescription + "</p>" +
            "</div>"
        );
        productPrice = product.productPrice;
    }
});


function infoForPremium(product) {
    if (getCookie("userType") == 0)
        return "";
    else {
        var discount = "<h4> Discount for premium users: " + product.discountForPremiumUsers + "%</h4> <h4 id=\"add\">Additions: ";
        additions = getAdditions();
        var add = "<div id=\"addition\"><select name=\"additions\" id=\"add\">";
        add += "<option value=none>None </option>";
        additions.forEach(addition => {
            add += "<option value=" + addition.additionName + ">" + addition.additionName + "</option>";
        });

        add += "</select></h4></div>";

        return discount + add;
    }
}

function getAdditions() {
    return $.ajax({
        type: "POST",
        url: "http://localhost:8080/public/additions",
        async: false,
        dataType: "json",

    }).responseJSON;

}