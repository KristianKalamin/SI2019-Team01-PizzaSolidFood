
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
    "<div class=\"col-lg-4 col-md-6 mb-4\">" +
    "<div class=\"card h-100\">" +
    "<a href=\"#\"><img class=\"card-img-top\" src=\"" + decodeBase64(product.image) + "\"></a>" +
    "<div class=\"card-body\">" +
    "<h4 class=\"card-title\">" +
    "<a href=\"item.html?" + product.productName + "\">" + product.productName + "</a>" +
    "</h4>" +
    "<h5>€" + product.productPrice + "</h5>" +
    "<p class=\"card-text\">" + product.productDescription + "</p>" +
    "</div>" +
    "</div>" +
    "</div>"
  );

}



