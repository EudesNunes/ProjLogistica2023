
function mostrarModal(botaoClicado, modalId) {
    $(modalId).modal("show");
    $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
}

$("#tabclientes").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalCliente");
});

$("#tabdactes").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalDacte");
});

$("#tabendereco").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalEndereco");
});

$("#tabfornecedor").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalfornededor");
});

$("#tabitemnota").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalItemNota");
});

$("#tabnotasfiscal").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalNotaFiscal");
});

$("#tabProdutos").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalProduto");
});

$("#tabregistros").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalRegistros");
});

$("#tabsituacao").on("click", ".js-delete", function () {
    let botaoClicado = $(this);
    mostrarModal(botaoClicado, "#modalSituacao");
});



