/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function inserAlumno()
{
    let nombre = document.getElementById("txtNombre").value;
    let apePaterno =document.getElementById("txtapePaterno").value;
    let apeMaterno= document.getElementById("txtapeMaterno").value;
    let genero = document.getElementById("txtgenero").value;
    let nivelEstu = document.getElementById("txtnivelEstudio").value;
    let ganancia = document.getElementById("txtGanacia").value;
    let telMovil = document.getElementById("txttelMovil").value;
    let email = document.getElementById("txtEmail").value;
    
    let nomUsu = document.getElementById("txtnomUsuario").value;
    let contra = document.getElementById("txtContrasenia").value;
    
    let Usu={nombre:nomUsu,contrasennia:contra};
    let alum= JSON.stringify({nombre:nombre,apePaterno:apePaterno,apeMaterno:apeMaterno,genero:genero,nivelEstudio:nivelEstu,telMovil:telMovil,email:email,ganancias:ganancia,usuario:Usu});
    
    let parametros= new URLSearchParams({datos:alum});
    
    fetch('api/alumno/insertAlum',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj = "Alumno registrado con exito " + data.idAlumno;
                alert(msj);
            });
}

function recuperarContr()
{
    let nombre = document.getElementById("txtUserName").value;
    let contra = document.getElementById("txtPassword").value;
    
    let usu= JSON.stringify({nombre:nombre,contrasennia:contra});
    
    let parametros=new URLSearchParams({datos:usu});
    
    fetch('api/alumno/recuperar',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj = "Contraseña restaurada";
                alert(msj);
            });
}