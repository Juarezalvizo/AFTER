/* 
Autor:Escobedo Gonzalez Emmanuel
Empresa: E-DDIT
Fecha:21/03/2023
Descripcion: 
  -  Dos constructores, uno con seis parámetros y otro con cinco.
  -  Métodos "getter" y "setter" para cada propiedad de la clase, que permiten acceder
     y establecer los valores de las mismas.
  - El método toString(), que devuelve una cadena de caracteres que representa el contenido
    del objeto de la clase Agenda.
  - También se definen seis propiedades (variables) de la clase, incluyendo idAgenda, 
    materia, actiTitulo, actiDes, fechaHoraReg y fechaHoraVenci.
 */

let agenda;

function insertar() {
    const usuario =JSON.parse(localStorage.getItem('currentUser'));
    let materia = (document.getElementById("txtMateria").value);
    let actiTitulo = (document.getElementById("txtActiTitulo").value);
    let actiDes = (document.getElementById("txtActiDes").value);
    let fechaHoraReg = (document.getElementById("txtFechaHoraReg").value);
    let fechaHoraVenci = (document.getElementById("txtFechaHoraVenci").value);

let usu = {usuario:usuario};
    let agenda =JSON.stringify({usuario:usu,materia: materia, actiTitulo: actiTitulo, actiDes: actiDes,
        fechaHoraReg: fechaHoraReg, fechaHoraVenci: fechaHoraVenci}) ;    
    let parametros = new URLSearchParams({datos: agenda});
    alert(parametros);
    fetch('api/agenda/insert',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                Swal.fire('Actividad insertada correctamente', '', "success");               
            });
}
function catalogoAgenda() {
    // Obtener el idUsuario del localStorage
    let idUsuario = localStorage.getItem("idUsuario");

    // Crear un objeto parametros con estatus e idUsuario
    let parametros = new URLSearchParams({
        estatus: "1",
        idUsuario: idUsuario
    });

    // Llamar al servicio getAll con la cadena de consulta como cuerpo de la solicitud
    fetch("api/agenda/getAll", {
        method: "POST",
        body: parametros,
        headers: { "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8" }
    })
    .then(response => response.json())
    .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarTablaA(data);
                }
            });
}


function cargarTablaA(data) {
    agenda = data;
    let contenidoTG = "";
    for (var i = 0; i < agenda.length; i++) {
        contenidoTG += "<tr>";
        let titulo = agenda[i].actiTitulo;
        contenidoTG += "<td>" + titulo + "</td>";
        let descripcion = agenda[i].actiDes;
        contenidoTG += "<td>" + descripcion + "</td>";
        contenidoTG += "<td><button onclick='eliminar(" + i + ");'>Eliminar</button></td>";
        contenidoTG += "<td><button onclick='cargarFrmE(" + i + ");'>Ver</button></td>";
        contenidoTG += "</tr>";
        
    }
    
    document.getElementById("tbAgenda").innerHTML = contenidoTG;
}
function cargarFrmE(i) {
    let materia = (document.getElementById("txtMateria").value);
    let actiTitulo = (document.getElementById("txtActiTitulo").value);
    let actiDes = (document.getElementById("txtActiDes").value);
    let fechaHoraReg = (document.getElementById("txtFechaHoraReg").value);
    let fechaHoraVenci = (document.getElementById("txtFechaHoraVenci").value);
    
    document.getElementById("txtMateria").value = agenda[i].materia;
    document.getElementById("txtActiTitulo").value = agenda[i].actiTitulo;
    document.getElementById("txtActiDes").value = agenda[i].actiDes;
    document.getElementById("txtFechaHoraReg").value = agenda[i].fechaHoraReg;
    document.getElementById("txtFechaHoraVenci").value = agenda[i].fechaHoraVenci;
    

}

function catalogoAgendaInctivos() {
    // Obtener el idUsuario del localStorage
    let idUsuario = localStorage.getItem("idUsuario");

    // Crear un objeto parametros con estatus e idUsuario
    let parametros = new URLSearchParams({
        estatus: "0",
        idUsuario: idUsuario
    });

    // Llamar al servicio getAll con la cadena de consulta como cuerpo de la solicitud
    fetch("api/agenda/getAllInactivos", {
        method: "POST",
        body: parametros,
        headers: { "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8" }
    })
    .then(response => response.json())
    .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarTablaAIna(data);
                }
            });
}
function cargarTablaAIna(data) {
    agenda = data;
    let contenidoTG = "";
    for (var i = 0; i < agenda.length; i++) {
        contenidoTG += "<tr>";
        let titulo = agenda[i].actiTitulo;
        contenidoTG += "<td>" + titulo + "</td>";
        let descripcion = agenda[i].actiDes;
        contenidoTG += "<td>" + descripcion + "</td>";        
        contenidoTG += "</tr>";
        
    }
    
    document.getElementById("tbAgenda").innerHTML = contenidoTG;
}

function eliminar(id) {
    let idAgenda = document.getElementById("txtIdAgenda").value;
    let parametros = new URLSearchParams({idUsuario: id});
    fetch("api/agenda/eliminar", {
        method: 'POST',
        body: (parametros),
        headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
    }).then(response => response.json())
            .then(data => {
                let msj = "Actividad elimianda";
                alert(msj);
            });
}