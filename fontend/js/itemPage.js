
var additions;

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
            "<h4> Pizza price: €" + product.productPrice + "</h4>" +
            "<p class=\"card-text\">" + product.productDescription + "</p>" +
            "</div>"
        );
    }
});


function infoForPremium(product) {
    if (getCookie("userType") == 1)
        return "";
    else {
        var discount = "<h4> Discount for premium users: " + product.discountForPremiumUsers + "%</h4> <h4>Additions: ";
        additions = getAdditions();
        var add = "<select name=\"additions\">";
        console.log(additions);
        additions.forEach(addition => {
            add += "<option value=" + addition.additionName + ">" + addition.additionName + "</option>";
        });

        add += "</select></h4>";

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


function order() {
    
}

