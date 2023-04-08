/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


///////////////////////////////////////////////////////////////////
/*
 boton de descargar
 */

// Obtener referencias a los elementos del DOM
const expandButton = document.querySelector('#expandButton');
const formulario = document.querySelector('#formulario');
const btnMostrar = document.querySelector('#btnMostrar');
const btnOcultar = document.querySelector('#btnOcultar');

// Agregar un evento de clic al botón "Ver más"
expandButton.addEventListener('click', () => {
  formulario.classList.toggle('expanded');
  if (expandButton.textContent === 'Ver más') {
    expandButton.textContent = 'Ver menos';
  } else {
    expandButton.textContent = 'Ver más';
  }
});

// Agregar un evento de clic al botón "Mostrar"
btnMostrar.addEventListener('click', () => {
  formulario.style.display = 'block';
  btnMostrar.style.display = 'none';
  btnOcultar.style.display = 'block';
});

// Agregar un evento de clic al botón "Ocultar"
btnOcultar.addEventListener('click', () => {
  formulario.style.display = 'none';
  btnOcultar.style.display = 'none';
  btnMostrar.style.display = 'block';
});
