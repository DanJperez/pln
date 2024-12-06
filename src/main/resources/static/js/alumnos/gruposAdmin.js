// Ejecutar cuando el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', () => {
    muestraTabla();
});

// Función para configurar y mostrar la tabla
function muestraTabla() {
    $('#tabla_Grupos').DataTable({
        ajax: {
            url: 'alumnos/listarGrupos', // Endpoint correcto para obtener los datos
            method: 'GET', // Método HTTP correcto
            dataSrc: '' // La respuesta es una lista directa de objetos JSON
        },
        responsive: true,
        processing: true,
        language: {
            processing: 'Procesando, espera...',
            lengthMenu: "Mostrar _MENU_ registros",
            zeroRecords: "No se encontraron resultados",
            info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
            infoEmpty: "No hay registros disponibles",
            infoFiltered: "(filtrado de _MAX_ registros totales)",
            search: "Buscar:",
            paginate: {
                previous: "Anterior",
                next: "Siguiente"
            }
        },
        columns: [
            { data: "id_grupo" },
            { data: "descripcion_grupo" },
            { data: "turno" }
        ]
    });
}

// Función para manejar el envío del formulario
$("#formGuardarGrupo").submit(function (e) {
    e.preventDefault(); // Evitar la recarga de la página

    // Obtener valores de los campos del formulario
    const grupo = $("#grupo").val();
    const turno = $("#turno").val();

    // Crear el objeto de datos
    const datos = {
        "descripcion_grupo": grupo,
        "turno": turno
    };

    // Realizar la solicitud AJAX para guardar el grupo
    $.ajax({
        type: "POST",
        url: "alumnos/guardarGrupos", // Endpoint para guardar grupos
        data: JSON.stringify(datos),
        contentType: "application/json",
        success: function (response) {
            // Verificar si la respuesta contiene un mensaje específico
            const mensaje = response && response.data
                ? response.data
                : "Grupo agregado correctamente";

            // Ocultar el modal y limpiar los campos del formulario
            $("#agregarGrupoModal").modal('hide');
            $("#grupo").val("");
            $("#turno").val("");

            // Mostrar un mensaje de éxito
            toastr.success(mensaje, "Éxito");

            // Recargar los datos de la tabla
            $('#tabla_Grupos').DataTable().ajax.reload();
        },
        error: function (xhr, status, error) {
            // Mostrar un mensaje de error detallado
            const errorMessage = xhr.responseText || "Ocurrió un error al guardar el grupo";
            toastr.error(errorMessage, "Error", { progressBar: true, closeButton: true });
        }
    });
});
