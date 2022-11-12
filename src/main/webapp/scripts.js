/**
 * Gestón del evento click del boton enviar para enviar los datos de una sala al aservidor
 * y que se guarde en la base de datos
 */
document.getElementById('btnSend').addEventListener('click',()=>{
    //Se capturan los datos de la vista
    const id = document.getElementById('id').value
    const desc = document.getElementById('desc').value
    const cap = document.getElementById('capacity').value

    //Se define, configura y gestiona la petición asíncrona de tipo POST, que se gestiona en el método
    //doPOst del Servlet
    const xhr = new XMLHttpRequest()
    xhr.open("POST","ServletRoom",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            //Validar el retorno, true indica que se insertó el registro false indica que no se insertó
            const resp = JSON.parse( xhr.responseText)
            if(resp.state){
                alert("Hecho, se inserto")
            }else{
                alert("No se ha insertado")
            }
        }
    }
    //Se alistan los datos para el envío
    const data = `id=${id}&desc=${desc}&cap=${cap}`;
    //Se inserta una anotación de cabecera para que reciba datos del cliente por POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //Se envían los datos
    xhr.send( data )
})

//Se gestiona el eevento click del botón, mediante una función de callback que mediante
//una llamada asíncrona al servidor trae los datos para visualizarlos en la consola del navegador
document.getElementById('btnLoad').addEventListener('click',()=>{
    const xhr = new XMLHttpRequest()
    xhr.open("GET",`ServletRoom`,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.status === 200 && xhr.readyState === 4){
            //Se obtiene la lista de Salas como un texto JSON en formato de coleccón por lo cual es iterable
            //Convertimos a un objeto iterable de Javascript
            const rooms = JSON.parse( xhr.responseText)
            //iteramos el objeto visualizando las salas en la consola
            rooms.forEach( room => {
                console.log(`Id=${room.id} Descripcion=${room.description} Capacidad=${room.capacity}`)
            })
        }
    }
    xhr.send(null)
})