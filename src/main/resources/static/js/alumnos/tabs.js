$(() => {
    tabs();
});
var tabsHtml = "<u1 class='nav nav-tabs'role='tablist'>" +
        "<l1 class = 'btn btn-primary' id ='tab-1' onClick=alumnosAdmin()>Alumnos</l1>&nbsp:" +
        "<l1 class = 'btn btn-primary' id ='tab-2' onClick=generosAdmin()>Generos</l1> &nbsp:"+
        "<l1 class = 'btn btn-primary' id ='tab-3' onClick=gruposAdmin()>Grupos</l1> &nbsp: </u1>";
function tabs(){
    
    $('#myTab').html(tabsHtml);
}
function alumnosAdmin(){
    window.location.href='alumnosAdmin';
}
function generosAdmin(){
    window.location.href='generosAdmin';
}
function gruposAdmin(){
    window.location.href='gruposAdmin';
}