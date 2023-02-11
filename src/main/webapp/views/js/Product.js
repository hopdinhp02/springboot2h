
document.addEventListener("DOMContentLoaded", function () {
    loadProduct()
});
// $(document).ready(function (){
//     loadProduct()
// })

let productDropDown = document.getElementById("product");
function loadProduct() {
    let url = "http://localhost:8080/api/v1/Products";
    fetch(url)
        .then(response => response.json())
        .then(data => {
            data.forEach(element => {
                var option = document.createElement("option");
                option.text = element.productName;
                option.value = element.id;
                productDropDown.appendChild(option);
            });

        })
        .catch(error => {
            console.error('Error:', error);
        });
}


// function loadProduct(){
//
//     let url = "http://localhost:8080/api/v1/Products";
// console.log(url);
//     $.get(url, function (responseJson){
//         $.each(responseJson, function (index, product){
//             $("<option>").val(product.id).text(product.productName).appendTo($("#product"));
//         })
//     })
//
//
// }

function addProduct() {
    url = "http://localhost:8080/api/v1/Products/insert";
    productName = document.getElementById("productName").value;
    jsonData = { productName: productName };
    fetch(url,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(jsonData)
        }
    )
        .then(respone => respone.json())
        .then(data => {

            console.log(data);
        }).catch(error => {
            console.error('Error:', error);
        });
}

// function addProduct() {
//     url = "http://localhost:8080/api/v1/Products/insert";
//     productName = $("#productName").val();
//     jsonData = { productName: productName };
//     console.log(jsonData);
//     $.ajax({
//         type: "Post",
//         url: url,
//         data: JSON.stringify(jsonData),
//         contentType: 'application/json'
//     }).done(function (response) {
//         newProduct(response.data.productName);
//     }).fail(function () {
//         alert("failed");
//     });
// }
function updateProduct() {
    productId = document.getElementById("product").value
    url = "http://localhost:8080/api/v1/Products/" + productId
    productName = document.getElementById("productName").value
    jsonData = { productName: productName };
    fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(jsonData)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        }).catch(error => {
            console.error('Error:', error);
        });
}
// function updateProduct() {
//     productId = $("#product").val();
//     url = "http://localhost:8080/api/v1/Products/" + productId;
//     productName = $("#productName").val();
//     jsonData = { productName: productName };
//     $.ajax({
//         type: "Put",
//         url: url,
//         data: JSON.stringify(jsonData),
//         contentType: 'application/json'
//     }).done(function (response) {
//         $("#product option:selected").text(productName);
//     }).fail(function () {
//         alert("failed");
//     });
// }

function deleteProduct() {
    productId = document.getElementById("product").value
    url = "http://localhost:8080/api/v1/Products/" + productId;
    fetch(url, {
        method: "DELETE"
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        }).catch(error => {
            console.error('Error:', error);
        });
}
// function deleteProduct() {
//     productId = $("#product").val();
//     url = "http://localhost:8080/api/v1/Products/" + productId;
//     $.ajax({
//         type: "Delete",
//         url: url,
//     }).done(function (response) {

//     }).fail(function () {
//         alert("failed");
//     });
// }

// function newProduct(productName) {
//     $("<option>").val(product.id).text(productName).appendTo($("#product"));
// }