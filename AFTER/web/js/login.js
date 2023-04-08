/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function regrsarLog()
{
    window.location.replace('../AFTER/index.html');
}
function crearCuente()
{
    window.location.replace('../AFTER/usuario.html');
}
function recuperar()
{
    window.location.replace('../AFTER/password.html');
}

async function encriptar(texto) {
    const encoder = new TextEncoder(); //Invocamos la clase q convierte un String en bytes
    const data = encoder.encode(texto);//Hace la conversión
    const hash = await crypto.subtle.digest('SHA-256', data); //crypto toma los bytes y los encripta, devuelve un buffer
    const hashArray = Array.from(new Uint8Array(hash)); // convierte el buffer en un arreglo de bytes
    const hashHex = hashArray.map((b) => b.toString(16).padStart(2, '0')).join(''); // convierte los bytes en string
    return hashHex;
}

function validarAcceso()
{
    let username = document.getElementById("txtUserName").value;
    let password = document.getElementById("txtPassword").value;
    
        let usuario = {"usuario": JSON.stringify({"nombre": username, "contrasennia": password})};
        alert(usuario);
        let params = new URLSearchParams(usuario);

        fetch("api/login/log",
                {method: "POST",
                    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                    body: params
                })
                .then(response => {
                    return response.json();
                })
                .then(function (data)
                {
                    if (data.exception != null)
                    {
                        Swal.fire('', 'Error interno del servidor. Intente nuevamente más tarde.', 'error');
                        return;
                    }
                    if (data.error != null)
                    {
                        //Swal.fire('', data.error, 'warning');
                        return;
                    }
                    if (data.usuario != null)
                    {
                        localStorage.setItem('currentUser', JSON.stringify(data));
                        window.location.replace('principal.html');
                    } else
                        Swal.fire('', 'Por el momento, solo los administradores tienen acceso al sistema.', 'warning');
                });
}
