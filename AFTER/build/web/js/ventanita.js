/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var contenedorVentanaModal = document.getElementById("contenedorVentanaModal");

function abrirVentanaModal() {
  fetch("ventanaAgenda.html")
    .then(response => response.text())
    .then(html => {
      contenedorVentanaModal.innerHTML = html;
      var btnCancelar = contenedorVentanaModal.querySelector("#btnCancelar");
      btnCancelar.onclick = function() {
        contenedorVentanaModal.innerHTML = "";
      }
    });
}
