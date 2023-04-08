/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let aviso;

document.addEventListener('DOMContentLoaded', cargarAvisos());

function insertAviso()
{
    let valorCheckbox = [];
    let j = 0;

    for (var i = 0; i < 7; i++) {
        var checkbox = document.getElementById("c1-" + i + "");
        if (checkbox.checked) {
            valorCheckbox[j] = checkbox.value;
            j++;
        }
    }

    const alumno = JSON.parse(localStorage.getItem('currentUser'));

    let nombre = document.getElementById("txtNombreAvi").value;
    let hora = document.getElementById("txtHora").value;

    let aviso = JSON.stringify({nombre: nombre, hora: hora, dia: valorCheckbox.toString(), usuario: alumno.usuario});
    let parametros = new URLSearchParams({datos: aviso});

    fetch("api/avisos/insertarAviso",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                let msj = "Se agrego con exito";
                alert(msj);
                cargarAvisos();
            });
}

function actualizarAviso()
{
    let valorCheckbox = [];
    let j = 0;

    for (var i = 0; i < 7; i++) {
        var checkbox = document.getElementById("c1-" + i + "");
        if (checkbox.checked) {
            valorCheckbox[j] = checkbox.value;
            j++;
        }
    }

    const alumno = JSON.parse(localStorage.getItem('currentUser'));
    
    let id = document.getElementById("txtidaviso").value;
    let nombre = document.getElementById("txtNombreAvi").value;
    let hora = document.getElementById("txtHora").value;

    let aviso = JSON.stringify({idAviso:id,nombre: nombre, hora: hora, dia: valorCheckbox.toString(), usuario: alumno.usuario});
    alert(aviso);
    let parametros = new URLSearchParams({datos: aviso});

    fetch("api/avisos/actualizarAviso",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                let msj = "Se modifico con exito";
                alert(msj);
                cargarAvisos();
            });
}

function eliminarAviso(i) {
    //let idEmpleado = document.getElementById("IdEmpleado").value;
    //let datos = {idEmpleado:idEmpleado };

    let parametros = new URLSearchParams({idAviso: i});

    fetch("api/avisos/eliminarAviso",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                let msj = "Aviso " + 1 + " Desactivado";
                alert(msj);
                cargarAvisos();
            });
}

function activarAviso(i) {
    //let idEmpleado = document.getElementById("IdEmpleado").value;
    //let datos = {idEmpleado:idEmpleado };

    let parametros = new URLSearchParams({idAviso: i});

    fetch("api/avisos/activarAviso",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                let msj = "Aviso " + 1 + " Activado";
                alert(msj);
                cargarAvisosElim();
            });
            
}

function eliminarDB(i) {
    //let idEmpleado = document.getElementById("IdEmpleado").value;
    //let datos = {idEmpleado:idEmpleado };

    let parametros = new URLSearchParams({idAviso: i});

    fetch("api/avisos/eliminarDB",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                let msj = "Se elimino el aviso " + 1;
                alert(msj);
            });
}

function cargarAvisos()
{
    const alumno = JSON.parse(localStorage.getItem('currentUser'));
    let id = JSON.stringify(alumno.usuario.idUsuario) ;
    //alert(id);
    let parametros = new URLSearchParams({estatus: 1,id:id});

    fetch("api/avisos/getAll",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);

                } else {
                    cargarTablaE(data);
                }
            });
}

function cargarTablaE(data) {
    aviso = data;
    let contenidoTE = "";
    for (var i = 0; i < aviso.length; i++) {
        contenidoTE += "<tr>";
        contenidoTE += "<td>" + aviso[i].nombre + "</td>";
        contenidoTE += "<td>" + aviso[i].dia + "</td>";
        contenidoTE += "<td>" + aviso[i].hora + "</td>";
        contenidoTE += "<td><button class='btn btn-outline-danger' onclick='eliminarAviso(" + (aviso[i].idAviso) + ")'>DESACTIVAR</button></td>";
        contenidoTE += "<td><button onclick='cargar(" + i + ");'>ver</button></td>";


        contenidoTE += "</tr>";
    }
    document.getElementById("tbAgenda").innerHTML = contenidoTE;
}

function cargarAvisosElim()
{
    const alumno = JSON.parse(localStorage.getItem('currentUser'));
    let id = JSON.stringify(alumno.usuario.idUsuario) ;
    //alert(id);
    let parametros = new URLSearchParams({estatus: 0,id:id});

    fetch("api/avisos/getAll",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);

                } else {
                    cargarTablaElim(data);
                }
            });
}

function cargarTablaElim(data) {
    aviso = data;
    let contenidoTE = "";
    for (var i = 0; i < aviso.length; i++) {
        contenidoTE += "<tr>";
        contenidoTE += "<td>" + aviso[i].nombre + "</td>";
        contenidoTE += "<td>" + aviso[i].dia + "</td>";
        contenidoTE += "<td>" + aviso[i].hora + "</td>";
        contenidoTE += "<td><button class='btn btn-outline-info' onclick='activarAviso(" + (aviso[i].idAviso) + ")'>Activar</button></td>";
        contenidoTE += "<td><button onclick='eliminarDB(" + (aviso[i].idAviso) + ");'>ELIMINAR</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tbAgenda").innerHTML = contenidoTE;
}

function cargar(h)
{
    let j = 0;

    let dis = aviso[h].dia;
    var arr = dis.split(',');

    for (var i = 0; i < 7; i++) {
        var miCheckbox1 = document.getElementById("c1-" + i + "");
            miCheckbox1.checked = false;
        var checkbox = document.getElementById("c1-" + i + "").value;
        if (checkbox == arr[j]) {
            var miCheckbox = document.getElementById("c1-" + i + "");
            miCheckbox.checked = true;
            j++;
        }
    }
    // separa la cadena en elementos de un array utilizando la coma como separador
    console.log(arr); // muestra ["manzana", "naranja", "platano"] en la consola
    console.log(arr[0]);

    document.getElementById("txtNombreAvi").value = aviso[h].nombre;
    document.getElementById("txtHora").value = aviso[h].hora;
    document.getElementById("txtidaviso").value=aviso[h].idAviso;
    
    console.log(aviso[h].idAviso);
}

function limpiar()
{
    for (var i = 0; i < 7; i++) {
        var miCheckbox1 = document.getElementById("c1-" + i + "");
            miCheckbox1.checked = false;
        
    }
    document.getElementById("txtNombreAvi").value = "";
    document.getElementById("txtHora").value = "";
    document.getElementById("txtidaviso").value="";    
}