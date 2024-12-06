document.addEventListener('DOMContentLoaded', () => {
    muestraTabla();
});

// Función para mostrar la tabla
function muestraTabla() {
    $('#tabla_Generos').DataTable({
        ajax: {
            url: 'alumnos/listarGeneros', // Endpoint para obtener datos
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
            { data: "id_genero", title: "ID" },
            { data: "descripcion_genero", title: "Género" }
        ]
    });
}

// Manejo del formulario para guardar género
$("#formGuardarGenero").submit(function (e) {
    e.preventDefault(); // Prevenir recarga
    var genero = $("#genero").val(); // Obtener valor del input

    // Validar que el campo no esté vacío
    if (!genero.trim()) {
        toastr.warning("El campo 'Género' es obligatorio", "Advertencia");
        return;
    }

    var datos = {
        "descripcion_genero": genero
    };

    $.ajax({
        type: "POST",
        url: "alumnos/guardarGenero", // Endpoint para guardar
        data: JSON.stringify(datos),
        contentType: "application/json",
        success: function (response) {
            toastr.success("Género agregado correctamente", "Éxito");
            $('#tabla_Generos').DataTable().ajax.reload(); // Recargar tabla
            $("#agregarGeneroModal").modal('hide'); // Cerrar modal
            $("#formGuardarGenero")[0].reset(); // Limpiar formulario
        },
        error: function (xhr, status, error) {
            var errorMessage = xhr.responseText || "Error al guardar el género";
            console.error("Error:", errorMessage);
            toastr.error(errorMessage, "Error");
        }
    });
});
