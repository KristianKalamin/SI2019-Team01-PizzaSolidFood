
$(document).ready(function () {
    $("#addition").click(function () {
        var x = $("#add option:selected").val();
        var price = 0;
        var newPrice = 0;
        price = productPrice;
        var add = additions.find(obj => {
            return obj.additionName === x;
        });

        if (x == "none") {
            newPrice = parseFloat(price);
        } else {
            newPrice = parseFloat(price) + parseFloat(add.additionPrice);
        }

        $("#price").text("Pizza price: €" + newPrice);
    });


    $("#btnOrderOne").click(function (e) {
        $(this).fadeOut("slow");
        setTimeout(function () {
            $("#address").fadeIn("slow");
        }, 500);

    });

});


function orderProduct() {
    var address = $("#addressInput").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/public/address",
        data: "userAddress=" + address,
        dataType: "json",
        success: function (response) {/* none */ }
    });

    var authToken = getCookie("token");
    var orderNum = getRandomNumber(10000, 99999);
    var userMail = getCookie("userEmail");
    var payment = $('input[name=payment]:checked').val();
    var quantity = $('#quantity').val();
    var product = $("h3").text();
    var op = $("#options:selected").val();

    if (op == 'none') {
        op = "";
    }

    var order = {
        mail: userMail,
        productName: product,
        payment: payment,
        quantity: quantity,
        orderNum: orderNum,
        additionName: op
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/auth/order",
        headers: { "Authorization": "Bearer " + authToken, },
        data: JSON.stringify(order),
        success: function (response) {
            /*none*/
        }
    });
}

