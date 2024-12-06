document.addEventListener('DOMContentLoaded', () => {
    muestraTabla();
});

// Función para mostrar la tabla con los alumnos
function muestraTabla() {
    $('#tabla_Alumnos').DataTable({
        ajax: {
            url: 'alumnos/listarAlumnos', // Endpoint para obtener los alumnos
            method: 'GET',
            dataSrc: '', // Si la respuesta es un array
            error: function (xhr, error, thrown) {
                console.error("Error al obtener datos:", xhr.responseText || error);
                toastr.error("No se pudieron cargar los datos", "Error");
            }
        },
        responsive: true,
        processing: true,
        language: {
            processing: 'Procesando, espera...',
            lengthMenu: "Mostrar _MENU_ registros",
            zeroRecords: "No se encontraron resultados",
            info: "Mostrando _START_ a _END_ de _TOTAL_",
            infoEmpty: "No hay registros disponibles",
            infoFiltered: "(filtrado de _MAX_ registros)",
            search: "Buscar:",
            paginate: {
                previous: "Anterior",
                next: "Siguiente"
            }
        },
        columns: [
            { data: "id_alumno", title: "ID" },
            { data: "nombre", title: "Nombre" },
            { data: "apellido_paterno", title: "Apellido Paterno" },
            { data: "apellido_materno", title: "Apellido Materno" },
            { data: "edad", title: "Edad" },
            { data: "generos.descripcion_genero", title: "Género" }
        ]
    });
}

// Manejo del formulario para guardar un nuevo alumno
$("#formGuardarAlumno").submit(function (e) {
    e.preventDefault(); // Prevenir recarga de la página

    // Obtener los valores del formulario
    var alumno = {
        id_alumno: 0, // Valor por defecto, si es necesario
        nombre: $("#nombre").val(),
        apellido_paterno: $("#apellido_paterno").val(),
        apellido_materno: $("#apellido_materno").val(),
        edad: $("#edad").val(),
        generos: {
            id_genero: $("#genero").val(),
            descripcion_genero: $("#genero option:selected").text()
        }
    };

    // Validación básica
    if (!alumno.nombre || !alumno.apellido_paterno || !alumno.edad || !alumno.generos.id_genero) {
        toastr.warning("Todos los campos son obligatorios", "Advertencia");
        return;
    }

    // Realizar la solicitud AJAX
    $.ajax({
        type: "POST",
        url: "alumnos/guardarAlumnos", // Endpoint para guardar el alumno
        data: JSON.stringify(alumno),
        contentType: "application/json",
        success: function (response) {
            toastr.success("Alumno agregado correctamente", "Éxito");
            $('#tabla_Alumnos').DataTable().ajax.reload(); // Recargar la tabla
            $("#agregarAlumnoModal").modal('hide'); // Cerrar el modal
            $("#formGuardarAlumno")[0].reset(); // Limpiar el formulario
        },
        error: function (xhr, status, error) {
            var errorMessage = xhr.responseText || "Error al guardar el alumno";
            console.error("Error:", errorMessage);
            toastr.error(errorMessage, "Error");
        }
    });
});
