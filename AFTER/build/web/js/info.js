/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//const expandButton = document.querySelector('.expand-button');
//const card = document.querySelector('.card');
//
//expandButton.addEventListener('click', function() {
//  card.classList.toggle('expanded');
//});
const expandButtons = document.querySelectorAll('.expand-button2');
const cards = document.querySelectorAll('.card');

for (let i = 0; i < expandButtons.length; i++) {
  expandButtons[i].addEventListener('click', function() {
    cards[i].classList.toggle('expanded');
  });
}
